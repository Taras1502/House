package dao;

import domain.Advertisement;

import java.util.List;

/**
 * Created by Taras.Mykulyn on 29.04.2015.
 */
public interface AdvertisementRepository extends GeneralRepository<Advertisement> {

    List findByConditions(String location, String type, double minPrice, double maxPrice,
                          int numberOfRooms, String status, int numberOfAdds, int lastId);

    int countByConditions(String location, String type, double minPrice, double maxPrice,
                          int numberOfRooms, String status);

}
