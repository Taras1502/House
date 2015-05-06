package dao;

import domain.User;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
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
    public int saveUser(User user) {
        Session session = null;
        int id = -1;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            id = (Integer) session.save(user);
            session.getTransaction().commit();
            return id;
        } catch (RuntimeException e) {
            e.printStackTrace();
            if (session != null) {
                session.getTransaction().rollback();
            }
            return -1;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    @Transactional
    public boolean updateUser(User user) {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.update(user);
            session.getTransaction().commit();
            return true;
        } catch (RuntimeException e) {
            e.printStackTrace();
            if (session != null) {
                session.getTransaction().rollback();
            }
            return false;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    @Transactional
    public boolean removeUser(int id) {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            User user = getUserById(id);
            if (user != null) {
                session.delete(user);
            } else {
                return false;
            }
            session.getTransaction().commit();
            return true;
        } catch (RuntimeException e) {
            e.printStackTrace();
            if (session != null) {
                session.getTransaction().rollback();
            }
            return false;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    @Transactional
    public User getUserById(int id) {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();

            String hql = "FROM User WHERE id = :id";
            Query query = sessionFactory.openSession().createQuery(hql);
            query.setParameter("id", id);
            List<User> userList = (List<User>) query.list();

            session.getTransaction().commit();
            if (userList != null && !userList.isEmpty()) {
                return userList.get(0);
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

    @Override
    @Transactional
    public List<User> getUsers(int lastId, int amount) {
        Session session = sessionFactory.openSession();
        Criteria criteria = session.createCriteria(User.class);
        criteria.add(Restrictions.gt("id", lastId));
        criteria.setMaxResults(amount);
        List userList = criteria.list();
        if (userList != null && !userList.isEmpty()) {
            return userList;
        }
        return null;
    }
}
