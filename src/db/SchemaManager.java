package db;

import com.mongodb.client.MongoDatabase;

public class SchemaManager {
    public static void createCollections() {
        MongoDatabase database = CreateConnection.getDatabase();

        // Create 'users' collection
        if (!collectionExists(database, "users")) {
            database.createCollection("users");
            System.out.println("Collection 'users' created successfully with schema.");
        }

        // Create 'gamePlay' collection
        if (!collectionExists(database, "gamePlay")) {
            database.createCollection("gamePlay");
            System.out.println("Collection 'gamePlay' created successfully with schema.");
        }

        // Create 'questions' collection
        if (!collectionExists(database, "questions")) {
            database.createCollection("questions");
            System.out.println("Collection 'questions' created successfully with schema.");
        }
    }

    private static boolean collectionExists(MongoDatabase database, String collectionName) {
        for (String name : database.listCollectionNames()) {
            if (name.equalsIgnoreCase(collectionName)) {
                return true;
            }
        }
        return false;
    }
}