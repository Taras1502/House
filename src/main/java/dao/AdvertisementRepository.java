package dao;

import domain.Addvertisement;

import java.util.List;

/**
 * Created by Taras.Mykulyn on 29.04.2015.
 */
public interface AdvertisementRepository {

    int addAddvertisement(Addvertisement add);

    boolean updateAddvertisement(Addvertisement add);

    boolean removeAddevertisement(int id);

    Addvertisement getAddvertisementById(int id);

    List getAddvertisementsByConditions(String location, String type, double minPrice, double maxPrice,
                                        int numberOfRooms, String status, int numberOfAdds, int lastId);

}
