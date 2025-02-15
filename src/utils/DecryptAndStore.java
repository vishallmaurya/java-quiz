package utils;

import java.nio.charset.StandardCharsets;
import java.security.*;
import javax.crypto.*;
import javax.crypto.spec.*;
import java.util.Base64;
import java.io.*;
import java.nio.file.*;
import javax.swing.JOptionPane;

public class DecryptAndStore {
    private static final String KEY_FILE = "encryption_key.key";
    private static final String ENCRYPTED_FILE = "encrypted_credentials.dat";

    public static void main(String[] args) {
        try {
            // Extract files from JAR to temp folder
            File keyFile = extractFile(KEY_FILE);
            File encryptedFile = extractFile(ENCRYPTED_FILE);

            // Read extracted key file
            byte[] keyBytes = Base64.getDecoder().decode(Files.readAllBytes(keyFile.toPath()));
            SecretKey secretKey = new SecretKeySpec(keyBytes, "AES");

            // Read extracted encrypted credentials file
            byte[] encryptedData = Base64.getDecoder().decode(Files.readAllBytes(encryptedFile.toPath()));

            // Decrypt the credentials
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            byte[] decryptedData = cipher.doFinal(encryptedData);
            String decryptedText = new String(decryptedData, StandardCharsets.UTF_8);

            // Store decrypted credentials securely
            storeInWindowsCredentialManager(decryptedText);

            // Delete extracted files
            deleteFile(keyFile);
            deleteFile(encryptedFile);

            System.out.println("Credentials stored securely! Extracted files deleted.");

            // Schedule self-deletion (JAR/EXE)
            scheduleSelfDeletion();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Extracts a file from inside the JAR to a temporary directory.
     */
    private static File extractFile(String resourceName) throws IOException {
        InputStream inputStream = DecryptAndStore.class.getClassLoader().getResourceAsStream(resourceName);
        if (inputStream == null) {
            throw new FileNotFoundException("Resource not found: " + resourceName);
        }

        // Save file in temp directory
        File tempFile = new File(System.getProperty("java.io.tmpdir"), resourceName);
        Files.copy(inputStream, tempFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
        inputStream.close();

        return tempFile;
    }

    /**
     * Stores decrypted credentials in Windows Credential Manager.
     */
    private static void storeInWindowsCredentialManager(String data) {
        try {
            ProcessBuilder processBuilder = new ProcessBuilder("cmdkey", "/generic:MyApp", "/user:" + data, "/pass:" + data);
            Process process = processBuilder.start();
            process.waitFor();

            JOptionPane.showMessageDialog(null, "Credentials stored securely!", "Success", JOptionPane.INFORMATION_MESSAGE);
            System.out.println("Credentials stored in Windows Credential Manager.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Deletes a file safely.
     */
    private static void deleteFile(File file) {
        try {
            if (Files.deleteIfExists(file.toPath())) {
                System.out.println("Deleted: " + file.getAbsolutePath());
            } else {
                System.out.println("File not found: " + file.getAbsolutePath());
            }
        } catch (Exception e) {
            System.err.println("Failed to delete: " + file.getAbsolutePath());
            e.printStackTrace();
        }
    }

    /**
     * Schedules self-deletion for JAR or EXE file after execution.
     */
    private static void scheduleSelfDeletion() {
        try {
            File runningFile = new File(DecryptAndStore.class.getProtectionDomain().getCodeSource().getLocation().toURI());

            if (runningFile.getName().endsWith(".jar") || runningFile.getName().endsWith(".exe")) {
                File deleteScript = new File(runningFile.getParent(), "delete_me.bat");

                // Create a batch script to delete the JAR/EXE after exit
                try (PrintWriter writer = new PrintWriter(deleteScript)) {
                    writer.println("@echo off");
                    writer.println("timeout /t 3 /nobreak > NUL"); // Wait for 3 seconds
                    writer.println("del \"" + runningFile.getAbsolutePath() + "\""); // Delete the JAR/EXE
                    writer.println("del \"%~f0\""); // Delete the batch script itself
                }

                // Execute the script in a separate process
                new ProcessBuilder("cmd.exe", "/c", deleteScript.getAbsolutePath()).start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
