package POST;

import java.util.List;

public class UserData {

    private List<User> blogs;

    public User createBlog(String vorname, String nachname) {
        User newBlog = new User(vorname, nachname);
        blogs.add(newBlog);
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
