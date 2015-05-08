package dao;

import domain.User;
import java.util.List;

/**
 * Created by Taras.Mykulyn on 29.04.2015.
 */
public interface UserRepository extends GeneralRepository<User> {

    // additional methods specific to the User Repository go here

    User findByUsername(String username);

}
