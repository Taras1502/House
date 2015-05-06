package dao;

import domain.Addvertisement;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by macbookpro on 5/5/15.
 */
public class AdvertisementRepositoryImpl implements AdvertisementRepository {

    @Autowired
    private SessionFactory sessionFactory;

    public AdvertisementRepositoryImpl() { }

    public AdvertisementRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @Transactional
    public int addAdvertisement(Addvertisement add) {
        Session session = null;
        int id = -1;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            id = (Integer) session.save(add);
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
    public boolean updateAdvertisement(Addvertisement add) {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.update(add);
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
    public boolean removeAdevertisement(int id) {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            Addvertisement add = getAdvertisementById(id);
            if (add != null) {
                session.delete(add);
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
    public Addvertisement getAdvertisementById(int id) {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();

            String hql = "FROM Addvertisement WHERE id = :id";
            Query query = sessionFactory.openSession().createQuery(hql);
            query.setParameter("id", id);
            List<Addvertisement> addList = (List<Addvertisement>) query.list();

            session.getTransaction().commit();
            if (addList != null && !addList.isEmpty()) {
                return addList.get(0);
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
    public List getAdvertisementsByConditions(String location, String type, double minPrice, double maxPrice,
                                               int numberOfRooms, String status, int numberOfAdds, int lastId) {
        Session session = sessionFactory.openSession();
        Criteria criteria = session.createCriteria(Addvertisement.class);
        if (location != null && !location.equals("")) {
            criteria.add(Restrictions.like("location", location));
        }
        if (type != null && !type.equals("")) {
            criteria.add(Restrictions.eq("type", type));
        }
        if (minPrice != -1) {
            criteria.add(Restrictions.ge("price", minPrice));
        }
        if (maxPrice != -1) {
            criteria.add(Restrictions.le("price", maxPrice));
        }
        if (numberOfRooms != -1) {
            criteria.add(Restrictions.eq("rooms", numberOfRooms));
        }
        if (status != null && !status.equals("")) {
            criteria.add(Restrictions.eq("type", type));
        }
        criteria.add(Restrictions.gt("id", lastId));
        criteria.setMaxResults(numberOfAdds);

        List addList = criteria.list();
        if (addList != null && !addList.isEmpty()) {
            return addList;
        }
        return null;
    }
}
