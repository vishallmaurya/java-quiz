package db;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class SchemaManager {
    public static void createCollections() {
        MongoDatabase database = CreateConnection.getDatabase();

        // Create 'users' collection
        if (!collectionExists(database, "users")) {
            database.createCollection("users");
            MongoCollection<Document> usersCollection = database.getCollection("users");
            // Document userSchema = new Document()
            //         .append("email", "example@example.com")
            //         .append("password", "hashed_password_here");
            // usersCollection.insertOne(userSchema);
            System.out.println("Collection 'users' created successfully with schema.");
        }

        // Create 'subjects' collection
        if (!collectionExists(database, "subjects")) {
            database.createCollection("subjects");
            MongoCollection<Document> subjectsCollection = database.getCollection("subjects");
            // Document subjectSchema = new Document()
            //         .append("subject_name", "Mathematics");
            // subjectsCollection.insertOne(subjectSchema);
            System.out.println("Collection 'subjects' created successfully with schema.");
        }

        // Create 'gamePlay' collection
        if (!collectionExists(database, "gamePlay")) {
            database.createCollection("gamePlay");
            MongoCollection<Document> gamePlayCollection = database.getCollection("gamePlay");
            // Document gamePlaySchema = new Document()
            //         .append("subject_chosen", "subject_id_placeholder")
            //         .append("score", 100)
            //         .append("user_id", "user_id_placeholder");
            // gamePlayCollection.insertOne(gamePlaySchema);
            System.out.println("Collection 'gamePlay' created successfully with schema.");
        }

        // Create 'questions' collection
        if (!collectionExists(database, "questions")) {
            database.createCollection("questions");
            MongoCollection<Document> questionsCollection = database.getCollection("questions");
            // Document questionSchema = new Document()
            //         .append("subject_id", "subject_id_placeholder")
            //         .append("question", "What is 2+2?");
            // questionsCollection.insertOne(questionSchema);
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