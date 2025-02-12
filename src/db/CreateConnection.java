package db;

import javax.swing.JOptionPane;

import com.mongodb.client.*;
import utils.EnvLoader;

public class CreateConnection {
    private static MongoClient mongoClient = null ;

    public static MongoDatabase getDatabase() {
        String uri="";
        try {
            
            if (mongoClient == null) {
                uri = EnvLoader.getEnv("DB_URL");
                mongoClient = MongoClients.create(uri);
            }
            return mongoClient.getDatabase(EnvLoader.getEnv("DB_NAME"));
        } catch (Exception exception) {
            JOptionPane.showMessageDialog(null, 
                            uri + "; " + exception.getMessage(), 
                "checking connectivity", 
                JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }

    public static void closeConnection() {
        if (mongoClient != null) {
            try {
                mongoClient.close();
                mongoClient = null;
            } catch (Exception exception) {
                System.err.println("Error occur during closing connection: " + exception.getMessage());
            }
        }
    }
}
