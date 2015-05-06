package dao;

import domain.Addvertisement;

import java.util.List;

/**
 * Created by Taras.Mykulyn on 29.04.2015.
 */
public interface AdvertisementRepository {

    int addAdvertisement(Addvertisement add);

    boolean updateAdvertisement(Addvertisement add);

    boolean removeAdevertisement(int id);

    Addvertisement getAdvertisementById(int id);

    List getAdvertisementsByConditions(String location, String type, double minPrice, double maxPrice,
                                        int numberOfRooms, String status, int numberOfAdds, int lastId);

}
