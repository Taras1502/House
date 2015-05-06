package dao;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * Created by Taras.Mykulyn on 06.05.2015.
 */

@Repository
@Transactional
public class GeneralRepositoryImpl<E> implements GeneralRepository<E> {

    SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public int add(E entity) {
        Session session = null;
        int id = -1;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            id = (Integer) session.save(entity);
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
    public boolean update(E entity) {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.update(entity);
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
    public boolean remove(int id) {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            E entity = findById(id);
            if (entity != null) {
                session.delete(entity);
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
    public E findById(int id) {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();

            String hql = "FROM User WHERE id = :id";
            Query query = sessionFactory.openSession().createQuery(hql);
            query.setParameter("id", id);
            List<E> entityList = (List<E>) query.list();

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

    @Override
    public List findAll(int lastId, int amount) {
        Session session = sessionFactory.openSession();
        Class entityClass = (Class<E>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        Criteria criteria = session.createCriteria(entityClass);
        criteria.add(Restrictions.gt("id", lastId));
        criteria.setMaxResults(amount);
        List entityList = criteria.list();
        if (entityList != null && !entityList.isEmpty()) {
            return entityList;
        }
        return null;
    }
}
