package dao;

import domain.User;
import java.util.List;

/**
 * Created by Taras.Mykulyn on 29.04.2015.
 */
public interface UserRepository {
    int saveUser(User user);

    boolean updateUser(User user);

    boolean removeUser(int id);

    User getUserById(int id);

    List<User> getUsers(int lastId, int amount);

}
