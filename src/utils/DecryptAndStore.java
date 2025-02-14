package utils;

import java.nio.file.*;
import java.nio.charset.StandardCharsets;
import java.security.*;
import javax.crypto.*;
import javax.crypto.spec.*;
import java.util.Base64;
import java.io.*;

public class DecryptAndStore {
    private static final String KEY_FILE = "encryption_key.key";
    private static final String ENCRYPTED_FILE = "encrypted_credentials.dat";

    public static void main(String[] args) {
        try {
            // Read AES key
            byte[] keyBytes = Base64.getDecoder().decode(Files.readAllBytes(Paths.get(KEY_FILE)));
            SecretKey secretKey = new SecretKeySpec(keyBytes, "AES");

            // Read encrypted data
            byte[] encryptedData = Base64.getDecoder().decode(Files.readAllBytes(Paths.get(ENCRYPTED_FILE)));

            // Decrypt data
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            byte[] decryptedData = cipher.doFinal(encryptedData);
            String decryptedText = new String(decryptedData, StandardCharsets.UTF_8);

            // Extract credentials
            String[] credentials = decryptedText.split(":");
            String clientId = credentials[0];
            String clientSecret = credentials[1];
            String orgainization_id = credentials[2];
            String project_id = credentials[3];

            // Store in Windows Credential Manager
            storeInWindowsCredentialManager(clientId, clientSecret, orgainization_id, project_id);

            // Delete sensitive files
            Files.deleteIfExists(Paths.get(ENCRYPTED_FILE));
            Files.deleteIfExists(Paths.get("DecryptAndStore.class"));
            // Files.deleteIfExists(Paths.get("DecryptAndStore.java"));

            System.out.println(" Credentials stored securely! Encrypted file and script deleted.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void storeInWindowsCredentialManager(String clientId, String clientSecret, String orgainization_id, String project_id) {
        try {
            String combinedSecret = clientSecret + ":" + orgainization_id + ":" + project_id;
            String command = String.format("cmdkey /generic:MyApp /user:%s /pass:%s", clientId, combinedSecret);
            Process process = Runtime.getRuntime().exec(command);
            process.waitFor();
            System.out.println("Credentials stored in Windows Credential Manager.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
