package model;

import java.util.HashMap;
import java.util.Map;

public class UserObject {
    private static UserObject instance = null;
    private static Map<String, User> users = new HashMap<String, User>();

    private UserObject() {
    }

    public static UserObject getInstance() {
        if (instance == null) {
            instance = new UserObject();
        }
        return instance;
    }

    public User authenticate(String username, String password) {
        User user = null;
        if (users.containsKey(username)) {
            if (user.getPassword().equals(password)) {
                user = users.get(username);
                return user;
            }
        }
        return user;
    }

    static {
        users.put("george", new User("george", "myPassword", "admin"));
        users.put("bogdan", new User("bodgan", "myPassword", "user"));
    }
}
