package by.divergenny.traveler.service.impl;

import by.divergenny.traveler.domain.Trip;
import by.divergenny.traveler.mapper.UserMapper;
import by.divergenny.traveler.persistence.TripRepository;
import by.divergenny.traveler.service.TripService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TripServiceImpl implements TripService {

    private final TripRepository tripRepository;

    private final UserMapper mapper;


    @Override
    public Trip add(Trip trip) {
        return tripRepository.insert(trip);
    }

    @Override
    public void deleteById(String id) {
        tripRepository.deleteById(id);
    }

    @Override
    public Trip getTripById(String id) {
        return tripRepository.getTripById(id);
    }

    @Override
    public List<Trip> getTripsByCountry(String country) {
        return tripRepository.getTripsByCountry(country);
    }

    @Override
    public Trip editTrip(String id, Trip tripWithNewData) {
        Trip tripInSystem = tripRepository.findById(id).orElse(null);
        if (null == tripInSystem) {
            return null;
        }
        checkAndSet(tripInSystem, tripWithNewData);
        tripRepository.save(tripInSystem);
        return tripInSystem;
    }

    public void checkAndSet(Trip tripInSystem, Trip tripWithNewData) {
        if (null != tripWithNewData.getDatestart()
                && !tripInSystem.getDatestart().equals(tripWithNewData.getDatestart())
        ) {
            tripInSystem.setDatestart(tripWithNewData.getDatestart());
        }
        if (null != tripWithNewData.getDateend()
                && !tripInSystem.getDateend().equals(tripWithNewData.getDateend())
        ) {
            tripInSystem.setDateend(tripWithNewData.getDateend());
        }
        if (null != tripWithNewData.getCountry()
                && !tripInSystem.getCountry().equals(tripWithNewData.getCountry())
        ) {
            tripInSystem.setCountry(tripWithNewData.getCountry());
        }
        if (null != tripWithNewData.getCity()
                && !tripWithNewData.getCity().isEmpty()
                && !tripInSystem.getCity().equals(tripWithNewData.getCity())
        ) {
            tripInSystem.setCity(tripWithNewData.getCity());
        }
        if (null != tripWithNewData.getExpenses()) {
            tripInSystem.setExpenses(tripWithNewData.getExpenses());
        }
        tripInSystem.setLookingForATravelingCompanion(tripWithNewData.getLookingForATravelingCompanion());
        tripInSystem.setBudget(tripWithNewData.getBudget());
    }

}
