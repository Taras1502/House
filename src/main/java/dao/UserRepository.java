package dao;

import domain.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Taras.Mykulyn on 29.04.2015.
 */
public interface UserRepository {
    @Transactional
    void saveUser(User user);
    @Transactional
    void updateUser(User user);
    @Transactional
    void removeUser(int id);
    @Transactional
    User getUserById(int id);
    @Transactional
    List<User> getAllUsers();

}
