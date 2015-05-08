package service;

import domain.Advertisement;
import domain.User;

import java.util.List;

/**
 * Created by Taras.Mykulyn on 06.05.2015.
 */
public interface AdvertisementService {

    boolean addAdvertisement(Advertisement advertisement);

    boolean updateAdvertisement(Advertisement advertisement);

    boolean removeAdvertisement(int id);

    Advertisement findAdvertisementById(int id);

    List<Advertisement> findAdvertisements(int lastId, int amount);

    int countAllAdvertisements(String status);

    int countAdvertisementsByConditions(String location, String type, double minPrice, double maxPrice,
                                        int numberOfRooms, String status);

}
