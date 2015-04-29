package dao;

import domain.User;
import java.util.List;

/**
 * Created by Taras.Mykulyn on 29.04.2015.
 */
public interface UserRepository {

    void saveUser(User user);

    void updateUser(User user);

    void removeUser(int id);

    User getUserById(int id);

    List<User> getAllUsers();

}
