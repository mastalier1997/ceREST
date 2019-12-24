package POST;

public class UserServiceImp implements UserService{
    @Override
    public boolean isValid(User user) {
        return user !=null;
    }
}
