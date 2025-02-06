package db;

import com.mongodb.client.*;
import utils.EnvLoader;

public class CreateConnection {
    private static MongoClient mongoClient = null ;

    public static MongoDatabase getDatabase() {
        try{
            if (mongoClient == null) {
                String uri = EnvLoader.getEnv("DB_URL");
                mongoClient = MongoClients.create(uri);
            }

            return mongoClient.getDatabase(EnvLoader.getEnv("DB_NAME"));
        } catch (Exception exception) {
            System.err.println("MongoDB Connectivity error: " + exception.getMessage());
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
