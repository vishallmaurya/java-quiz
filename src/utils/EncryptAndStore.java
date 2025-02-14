package utils;

import java.nio.file.*;
import java.nio.charset.StandardCharsets;
import java.security.*;
import javax.crypto.*;
import javax.crypto.spec.*;
import java.util.Base64;
import java.io.*;

public class EncryptAndStore {
    private static final String KEY_FILE = "encryption_key.key";
    private static final String ENCRYPTED_FILE = "encrypted_credentials.dat";

    public static void main(String[] args) {
        try {
            // Generate AES key (Run once and save securely)
            KeyGenerator keyGen = KeyGenerator.getInstance("AES");
            keyGen.init(256);
            SecretKey secretKey = keyGen.generateKey();

            // Save the key securely (DO NOT bundle with .exe)
            Files.write(Paths.get(KEY_FILE), Base64.getEncoder().encode(secretKey.getEncoded()));

            // Replace with actual credentials
            String clientId = "MYAwstvWV1CtPbqIihEF7P6W0fkxSaKR";
            String clientSecret = "7d2w5uar9fwIq1nfvdiW2ndxXJdvO2tZd1VcMeeKXko0p4KNWVHKhFWTVQhBELKQ";
            String orgainization_id = "4d12f8a3-0479-4b56-9ae1-b7c6d44068cd";
            String project_id = "74d3a541-2f47-41ea-9023-ad4158747a82";
            String data = clientId + ":" + clientSecret + ":" + orgainization_id + ":" + project_id;

            // Encrypt data
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            byte[] encryptedData = cipher.doFinal(data.getBytes(StandardCharsets.UTF_8));

            // Save encrypted file
            Files.write(Paths.get(ENCRYPTED_FILE), Base64.getEncoder().encode(encryptedData));

            System.out.println(" Encrypted file created: " + ENCRYPTED_FILE);
            System.out.println(" Save the encryption key separately (DO NOT bundle with .exe)");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
