package POST;

import java.util.List;

public class UserData {


    public User createBlog(String vorname, String nachname) {
        User newBlog = new User(vorname, nachname);
        return newBlog;
    }

    private static UserData instance = null;
    public static UserData getInstance(){
        if(instance == null){
            instance = new UserData();
        }
        return instance;
    }
}
