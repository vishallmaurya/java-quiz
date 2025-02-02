package db;

import com.mongodb.client.*;
import utils.EnvLoader;

public class CreateConnection {
    private static MongoClient mongoClient = null ;

    public static MongoDatabase getDatabase() {
        if (mongoClient == null) {
            String uri = EnvLoader.getEnv("DB_URL");
            mongoClient = MongoClients.create(uri);
        }

        return mongoClient.getDatabase(EnvLoader.getEnv("DB_NAME"));
    }

    public static void closeConnection() {
        if (mongoClient != null) {
            mongoClient.close();
            mongoClient = null;
        }
    }
}
