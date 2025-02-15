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
            byte[] keyBytes = Base64.getDecoder().decode(Files.readAllBytes(Paths.get(KEY_FILE)));
            SecretKey secretKey = new SecretKeySpec(keyBytes, "AES");

            byte[] encryptedData = Base64.getDecoder().decode(Files.readAllBytes(Paths.get(ENCRYPTED_FILE)));

            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            byte[] decryptedData = cipher.doFinal(encryptedData);
            String decryptedText = new String(decryptedData, StandardCharsets.UTF_8);

            storeInWindowsCredentialManager(decryptedText);

            Files.deleteIfExists(Paths.get(ENCRYPTED_FILE));
            Files.deleteIfExists(Paths.get("DecryptAndStore.class"));
            // Files.deleteIfExists(Paths.get("DecryptAndStore.java"));

            System.out.println(" Credentials stored securely! Encrypted file and script deleted.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void storeInWindowsCredentialManager(String data) {
        try {
            String command = String.format("cmdkey /generic:MyApp /user:%s /pass:%s", data, data);
            Process process = Runtime.getRuntime().exec(command);
            process.waitFor();
            System.out.println("Credentials stored in Windows Credential Manager.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
