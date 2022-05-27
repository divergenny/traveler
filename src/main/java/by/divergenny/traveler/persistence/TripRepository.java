package by.divergenny.traveler.persistence;

import by.divergenny.traveler.domain.Trip;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TripRepository extends MongoRepository<Trip, String> {

    Trip insert(Trip trip);

    void deleteById(String id);

    Trip getTripById(String id);

    List<Trip> getTripsByCountry(String country);
}
