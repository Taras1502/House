package dao;

import domain.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Taras.Mykulyn on 4/29/15.
 */

@Repository
@Transactional
public class UserRepositoryImpl extends GeneralRepositoryImpl<User> implements UserRepository {
    @Override
    public User findByUsername(String username) {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();

            String hql = "FROM User WHERE username = :username";
            Query query = sessionFactory.openSession().createQuery(hql);
            query.setParameter("username", username);
            List<User> entityList = (List<User>) query.list();

            session.getTransaction().commit();
            if (entityList != null && !entityList.isEmpty()) {
                return entityList.get(0);
            } else {
                return null;
            }
        } catch (RuntimeException e) {
            e.printStackTrace();
            if (session != null) {
                session.getTransaction().rollback();
            }
            return null;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    // implementation of declared methods in UserRepository interface go here

}
