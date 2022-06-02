package by.divergenny.traveler.service.impl;

import by.divergenny.traveler.domain.Trip;
import by.divergenny.traveler.mapper.UserMapper;
import by.divergenny.traveler.persistence.TripRepository;
import by.divergenny.traveler.service.TripService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
        Optional<Trip> tripInSystem = tripRepository.findById(id);
        if (tripInSystem.isEmpty()) {
            return null;
        }
        checkAndSet(tripInSystem.get(), tripWithNewData);
        tripRepository.save(tripInSystem.get());
        return tripInSystem.get();
    }

    private void checkAndSet(Trip tripInSystem, Trip tripWithNewData) {
        if (null != tripWithNewData.getDateStart()
                && !tripInSystem.getDateStart().equals(tripWithNewData.getDateStart())
        ) {
            tripInSystem.setDateStart(tripWithNewData.getDateStart());
        }
        if (null != tripWithNewData.getDateEnd()
                && !tripInSystem.getDateEnd().equals(tripWithNewData.getDateEnd())
        ) {
            tripInSystem.setDateEnd(tripWithNewData.getDateEnd());
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
