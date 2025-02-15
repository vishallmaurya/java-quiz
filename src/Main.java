import db.CreateConnection;
import quiz.StartFrame;
import utils.DecryptAndStore;

public class Main {
    public static void main(String[] args) {
        try {
            DecryptAndStore.main(null);
            Runtime.getRuntime().addShutdownHook(new Thread(() -> {
                CreateConnection.closeConnection();
            }));

            new StartFrame();
        } catch (Exception e) {
            System.err.println("Error occured " + e.getMessage());
        }
    }
}
