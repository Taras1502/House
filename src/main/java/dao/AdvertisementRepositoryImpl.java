package dao;

import domain.Addvertisement;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Taras.Mykukyn on 5/5/15.
 */

@Repository
@Transactional
public class AdvertisementRepositoryImpl extends GeneralRepositoryImpl<Addvertisement> implements AdvertisementRepository {

    @Override
    public List findByConditions(String location, String type, double minPrice, double maxPrice, int numberOfRooms, String status, int numberOfAdds, int lastId) {
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
