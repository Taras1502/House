package dao;

import domain.Addvertisement;

import java.util.List;

/**
 * Created by Taras.Mykulyn on 29.04.2015.
 */
public interface AddvertisementRepository {

    void addAddvertisement(Addvertisement add);

    void updateAddvertisement(Addvertisement add);

    void removeAddevertisement(int id);

    Addvertisement getAddvertisementById(int id);

    List<Addvertisement> getAddvertisementByConditions(String location, String type, double minPrice, double maxPrice,
                                                       int numberOfRooms, String status, int numberOfAdds, int lastId);

}
