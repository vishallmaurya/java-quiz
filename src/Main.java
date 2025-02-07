import db.CreateConnection;
import quiz.StartFrame;

public class Main {
    public static void main(String[] args) {
        try {
            new StartFrame();
        } catch (Exception e) {
            System.err.println("Error occured " + e.getMessage());
        } finally {
            CreateConnection.closeConnection();
        }
    }
}
