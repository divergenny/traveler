package by.divergenny.traveler.service.impl;

import by.divergenny.traveler.domain.Trip;
import by.divergenny.traveler.domain.User;
import by.divergenny.traveler.mapper.UserMapper;
import by.divergenny.traveler.persistence.TripRepository;
import by.divergenny.traveler.service.TripService;
import by.divergenny.traveler.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.client.utils.URIBuilder;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class TripServiceImpl implements TripService {

    private final TripRepository tripRepository;

    private final UserMapper mapper;

    private final UserService userService;

    private final CallTripSendEmailFunctionServiceImpl callSendEmailTrip;

    @Override
    public Trip add(Trip trip) {
        log.trace("Method add, id -> {}", trip);
        Trip newTrip = tripRepository.insert(trip);
        callSendEmailTrip.callSendEmailOfTrip(newTrip);
        return newTrip;
    }

    @Override
    public void deleteById(String id) {
        log.trace("Method deleteById, id -> {}", id);
        tripRepository.deleteById(id);
    }

    @Override
    public Trip getTripById(String id) {
        log.trace("Method getTripById, id -> {}", id);
        return tripRepository.getTripById(id);
    }

    @Override
    public List<Trip> getTripsByCountry(String country) {
        log.trace("Method getTripsByCountry, country -> {}", country);
        return tripRepository.getTripsByCountry(country);
    }

    @Override
    public Trip editTrip(String id, Trip tripWithNewData) {
        log.trace("Method editTrip, id -> {}, tripWithNewData -> {}", id, tripWithNewData);
        Optional<Trip> tripInSystem = tripRepository.findById(id);
        if (tripInSystem.isEmpty()) {
            log.trace("Method editTrip, tripInSystem is Empty, so no trip in system with id -> {}", id);
            return null;
        }
        checkAndSet(tripInSystem.get(), tripWithNewData);
        tripRepository.save(tripInSystem.get());
        return tripInSystem.get();
    }

    private void checkAndSet(Trip tripInSystem, Trip tripWithNewData) {
        log.trace("Method checkAndSet, tripInSystem -> {}, tripWithNewData -> {}", tripInSystem, tripWithNewData);
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
