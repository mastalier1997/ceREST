package POST;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

public class UserAPI {
    UserData userData = UserData.getInstance();

    @PostMapping(value = "/createUser", consumes = "application/json", produces = "application/json")
    public User createUser(@RequestBody Map<String, String> user) {
        String vorname = user.get("vorname");
        String nachname = user.get("nachname");
        return userData.createBlog(vorname, nachname);
    }
}