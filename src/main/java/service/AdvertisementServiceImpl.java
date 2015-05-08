package service;

import dao.AdvertisementRepository;
import domain.Advertisement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Taras.Mykulyn on 08.05.2015.
 */
@Service
public class AdvertisementServiceImpl implements AdvertisementService {
    AdvertisementRepository advertisementRepository;

    public AdvertisementServiceImpl() { }

    @Autowired
    public void setAdvertisementRepository(AdvertisementRepository advertisementRepository) {
        this.advertisementRepository = advertisementRepository;
    }

    @Override
    public boolean addAdvertisement(Advertisement advertisement) {
        int id = advertisementRepository.add(advertisement);
        return id != -1;
    }

    @Override
    public boolean updateAdvertisement(Advertisement advertisement) {
        boolean success = advertisementRepository.update(advertisement);
        return success;
    }

    @Override
    public boolean removeAdvertisement(int id) {
        boolean success = advertisementRepository.remove(id);
        return success;
    }

    @Override
    public Advertisement findAdvertisementById(int id) {
        Advertisement advertisement = advertisementRepository.findById(id);
        return advertisement;
    }

    @Override
    public List<Advertisement> findAdvertisements(int lastId, int amount) {
        List<Advertisement> advertisements = advertisementRepository.findAll(lastId, amount);
        return advertisements;
    }

    @Override
    public int countAllAdvertisements(String status) {
        int numberOfAdds = advertisementRepository.countByConditions(null, null, -1, -1, -1, status);
        return numberOfAdds;
    }

    @Override
    public int countAdvertisementsByConditions(String location, String type, double minPrice, double maxPrice, int numberOfRooms, String status) {
        int numberOfAdds = advertisementRepository.countByConditions(location, type, minPrice, maxPrice, numberOfRooms, status);
        return numberOfAdds;
    }
}
