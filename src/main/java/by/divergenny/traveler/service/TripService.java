package by.divergenny.traveler.service;

import by.divergenny.traveler.domain.Trip;

import java.util.List;

public interface TripService {

    Trip add(Trip trip);

    void deleteById(String id);

    Trip getTripById(String id);

    List<Trip> getTripsByCountry(String country);

    Trip editTrip(String id, Trip trip);
}
