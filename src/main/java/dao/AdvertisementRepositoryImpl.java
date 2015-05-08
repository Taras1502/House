package dao;

import domain.Advertisement;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Taras.Mykukyn on 5/5/15.
 */

@Repository
@Transactional
public class AdvertisementRepositoryImpl extends GeneralRepositoryImpl<Advertisement> implements AdvertisementRepository {

    @Override
    public List findByConditions(String location, String type, double minPrice, double maxPrice, int numberOfRooms, String status, int numberOfAdds, int lastId) {
        Session session = sessionFactory.openSession();
        Criteria criteria = fillCriteria(session, location, type, minPrice, maxPrice, numberOfRooms, status);
        criteria.add(Restrictions.gt("id", lastId));
        criteria.setMaxResults(numberOfAdds);

        List addList = criteria.list();
        if (addList != null && !addList.isEmpty()) {
            return addList;
        }
        return null;
    }

    @Override
    public int countByConditions(String location, String type, double minPrice, double maxPrice,
                                 int numberOfRooms, String status) {
        Session session = sessionFactory.openSession();
        Criteria criteria = fillCriteria(session, location, type, minPrice, maxPrice, numberOfRooms, status);
        return (Integer) criteria.setProjection(Projections.rowCount()).uniqueResult();
    }

    private Criteria fillCriteria(Session session, String location, String type, double minPrice,
                                  double maxPrice, int numberOfRooms, String status) {
        Criteria criteria = session.createCriteria(Advertisement.class);
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
        return criteria;
    }
}
