package by.divergenny.traveler.web;

import by.divergenny.traveler.domain.Trip;
import by.divergenny.traveler.service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/trips")
public class TripController {

    @Autowired
    private TripService tripService;

    @PostMapping("addTrip")
    public Trip addTrip(@RequestBody Trip trip) {
        return tripService.add(trip);
    }

    @DeleteMapping("deleteTripById/{tripId}")
    public void deleteTripById(@PathVariable String tripId) {
        tripService.deleteById(tripId);
    }

    @GetMapping("findTripById/{tripId}")
    public Trip findTripById(@PathVariable String tripId) {
        return tripService.getTripById(tripId);
    }

    @GetMapping("findTripsByCountry/{country}")
    public List<Trip> findTripsByCountry(@PathVariable String country) {
        return tripService.getTripsByCountry(country);
    }

    @PutMapping("editTrip/{tripId}")
    public Trip editUser(@PathVariable String tripId, @RequestBody Trip trip) {
        return tripService.editTrip(tripId, trip);
    }
}
