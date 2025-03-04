package db;

import com.mongodb.client.MongoDatabase;

public class SchemaManager {
    public static void createCollections() {
        try{
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

            // Create 'category' collection
            if (!collectionExists(database, "category")) {
                database.createCollection("category");
                System.out.println("Collection 'category' created successfully!");
            }

            // Create 'questions' collection
            if (!collectionExists(database, "questions")) {
                database.createCollection("questions");
                System.out.println("Collection 'questions' created successfully with schema.");
            }
        }catch(Exception exception){
            System.err.println("Error occured during creation of Schema:  " + exception.getMessage());
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

    public static void main(String[] args) {
        SchemaManager.createCollections();;
    }
}