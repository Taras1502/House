package dao;

import domain.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Taras.Mykulyn on 4/29/15.
 */

@Repository
@Transactional
public class UserRepositoryImpl extends GeneralRepositoryImpl<User> implements UserRepository {

    // implementation of declared methods in UserRepository interface go here

}
