package POST;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class UserAPI {
    UserData userData = UserData.getInstance();

    @PostMapping(value = "/createUser")
    public User createUser(@RequestBody User user) {
        //System.out.println( "User hinzugefügt");
        return userData.createBlog(user.getVorname(), user.getNachname());

    }

}
