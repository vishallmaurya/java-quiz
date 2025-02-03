package auth;

import org.bson.types.ObjectId;

public class Authenticate {
    private static ObjectId userId;

    public static boolean isUserExist() {
        return userId != null;
    }

    public static ObjectId getUser() {
        return userId;
    }

    public static void setUser(ObjectId id) {
        userId = id;
    }
}
