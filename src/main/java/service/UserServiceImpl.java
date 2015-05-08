package service;

import dao.UserRepository;
import domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Taras.Mykulyn on 08.05.2015.
 */
@Service
public class UserServiceImpl implements UserService {
    UserRepository userRepository;

    public UserServiceImpl() { }

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public boolean addUser(User user) {
        int id = userRepository.add(user);
        return id != -1;
    }

    @Override
    public boolean updateUser(User user) {
        boolean status = userRepository.update(user);
        return status;
    }

    @Override
    public boolean removeUser(int id) {
        boolean status = userRepository.remove(id);
        return status;
    }

    @Override
    public User findUserById(int id) {
        User user = userRepository.findById(id);
        return user;
    }

    @Override
    public List<User> findUsers(int lastId, int amount) {
        List<User> users = userRepository.findAll(lastId, amount);
        return users;
    }
}
