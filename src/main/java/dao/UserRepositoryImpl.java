package dao;

import domain.User;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.LocalSessionFactoryBean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by macbookpro on 4/29/15.
 */
@Repository
@Transactional
public class UserRepositoryImpl implements UserRepository {
    @Autowired
    private SessionFactory sessionFactory;

    public UserRepositoryImpl() {}

    public UserRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @Transactional
    public void saveUser(User user) {

    }

    @Override
    @Transactional
    public void updateUser(User user) {

    }

    @Override
    @Transactional
    public void removeUser(int id) {

    }

    @Override
    @Transactional
    public User getUserById(int id) {
        String hql = "from User where id=" + id;
        Query query = sessionFactory.openSession().createQuery(hql);

        @SuppressWarnings("unchecked")
        List<User> listUser = (List<User>) query.list();

        if (listUser != null && !listUser.isEmpty()) {
            return listUser.get(0);
        }
        System.out.println(listUser.get(0).getFirstName());
        return null;
    }

    @Override
    @Transactional
    public List<User> getAllUsers() {
        return null;
    }
}
