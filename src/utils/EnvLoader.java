package utils;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

final public class EnvLoader {
    private static final String ENV_FILE = ".env";
    private static final Map<String, String> envVariables = new HashMap<>();

    static {
        loadEnvFile();
    }

    private static void loadEnvFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(ENV_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains("=") && !line.startsWith("#")) {
                    String[] parts = line.split("=", 2);
                    envVariables.put(parts[0].trim(), parts[1].trim());
                }
            }
        } catch (IOException e) {
            System.err.println("Error loading .env file: " + e.getMessage());
        }
    }

    public static String getEnv(String key) {
        String value = envVariables.get(key);
        if (value != null && !value.isEmpty()) {
            return value;
        }

        String vaultValue = VaultClient.getSecret(key);

        if (vaultValue != null && !vaultValue.isEmpty()) {
            return vaultValue;
        }

        return null;
    }
}
