package utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.io.OutputStream;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class VaultClient {
    private static String CLIENT_ID = null;  
    private static String CLIENT_SECRET = null;
    private static String ORG_ID = null; 
    private static String PROJECT_ID = null;
    private static final String APP_NAME = "Quizathon"; 
    private static final String TOKEN_URL = "https://auth.idp.hashicorp.com/oauth2/token";
    
    private static Map<String, String> secrets = null;

    private static void initialize() {
        String credentials = getCredentialsFromWindowsCredentialManager("MyApp");
        
        if (credentials != null) {        
            String[] secretParts = credentials.split(":");
            
            CLIENT_ID = secretParts[0];
            CLIENT_SECRET = secretParts[1];
            ORG_ID = secretParts[2];
            PROJECT_ID = secretParts[3];
        }
    }

    private static String getHcpApiToken() {
        try {
            URL url = new URL(TOKEN_URL);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            conn.setDoOutput(true);

            String data = "client_id=" + CLIENT_ID +
                          "&client_secret=" + CLIENT_SECRET +
                          "&grant_type=client_credentials" +
                          "&audience=https://api.hashicorp.cloud";

            try (OutputStream os = conn.getOutputStream()) {
                os.write(data.getBytes(StandardCharsets.UTF_8));
            }

            int responseCode = conn.getResponseCode();
            if (responseCode != 200) {
                System.err.println("Error: " + responseCode + " - " + conn.getResponseMessage());
                return null;
            }

            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream(), StandardCharsets.UTF_8));
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();

            String responseBody = response.toString();
            int startIndex = responseBody.indexOf("\"access_token\":\"") + 16;
            int endIndex = responseBody.indexOf("\"", startIndex);
            return (startIndex > 15 && endIndex > startIndex) ? responseBody.substring(startIndex, endIndex) : null;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static void fetchAllSecrets() {
        secrets = new HashMap<>();
        try {
            String apiToken = getHcpApiToken();
            if (apiToken == null) {
                System.err.println("Failed to retrieve API token.");
                return ;
            }
            String VAULT_URL = "https://api.cloud.hashicorp.com/secrets/2023-11-28/organizations/" + ORG_ID +
            "/projects/" + PROJECT_ID + "/apps/" + APP_NAME + "/secrets:open";

            URL url = new URL(VAULT_URL);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Authorization", "Bearer " + apiToken);

            int responseCode = conn.getResponseCode();
            if (responseCode != 200) {
                System.err.println("Error: " + responseCode + " - " + conn.getResponseMessage());
                return ;
            }

            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream(), StandardCharsets.UTF_8));
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();

            String responseBody = response.toString();
            int index = 0;
            while ((index = responseBody.indexOf("\"name\":\"", index)) != -1) {
                int nameStart = index + 8;
                int nameEnd = responseBody.indexOf("\"", nameStart);
                String secretName = responseBody.substring(nameStart, nameEnd);

                int valueStart = responseBody.indexOf("\"value\":\"", nameEnd) + 9;
                int valueEnd = responseBody.indexOf("\"", valueStart);
                String secretValue = responseBody.substring(valueStart, valueEnd);

                secrets.put(secretName, secretValue);
                index = valueEnd;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getSecret(String secretName) {
        if (secrets == null) {
            initialize();
            fetchAllSecrets();
        }
        return secrets.getOrDefault(secretName, null);
    }

    private static String getCredentialsFromWindowsCredentialManager(String targetName) {
        try {
            Process process = Runtime.getRuntime().exec("cmdkey /list");
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            boolean found = false;
            String username = null;

            while ((line = reader.readLine()) != null) {
                line = line.trim();

                if (line.startsWith("Target:") && line.contains(targetName)) {
                    found = true;
                }

                if (found && line.startsWith("User:")) {
                    String[] parts = line.split(":", 2);
                    if (parts.length > 1) {
                        username = parts[1].trim();
                    }
                    break;
                }
            }

            process.waitFor();
            reader.close();

            if (username != null) {
                return username;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
