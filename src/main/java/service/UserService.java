package service;

import domain.User;

import java.util.List;

/**
 * Created by Taras.Mykulyn on 06.05.2015.
 */
public interface UserService {

    int addUser(User user);

    boolean updateUser(User user);

    boolean removeUser(int id);

    User findUserById(int id);

    List<User> findUsers(int lastId, int amount);

    boolean checkUserCredentials(String email, String password);

}
