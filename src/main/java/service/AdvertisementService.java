package service;

import domain.Advertisement;
import domain.User;

import java.util.List;

/**
 * Created by Taras.Mykulyn on 06.05.2015.
 */
public interface AdvertisementService {

    int addAdvertisement(Advertisement advertisement);

    boolean updateAdvertisement(Advertisement advertisement);

    boolean removeAdvertisement(int id);

    Advertisement findAdvertisementById(int id);

    List<User> findAdvertisements(int lastId, int amount);

    int countAllAdvertisements();

    int countAdvertisementsByConditions(String location, String type, double minPrice, double maxPrice,
                                        int numberOfRooms, String status, int numberOfAdds, int lastId);

}
