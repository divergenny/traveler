package by.divergenny.traveler.service.impl;

import by.divergenny.traveler.domain.Trip;
import by.divergenny.traveler.persistence.TripRepository;
import by.divergenny.traveler.service.TripService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
class TripServiceImplTest {
    @MockBean
    private TripService tripService;

    @MockBean
    private TripRepository tripRepo;


    @Test
    void add() {
        Trip trip = new Trip("1", "1", Date.valueOf("2022-01-01"),
                Date.valueOf("2023-01-01"), "USA",
                "Philadelphia", 100,
                List.of(""), true);
        Mockito.doReturn(trip).when(tripRepo).insert((Trip) any());
        //when(tripRepo.insert((Trip) any())).thenReturn(trip);
        Trip createdTripEntity = tripService.add(trip);
        Assertions.assertEquals(trip, createdTripEntity);
    }

    @Test
    void editTrip() {
        Trip trip = new Trip("1", "1", Date.valueOf("2022-01-01"),
                Date.valueOf("2023-01-01"), "USA",
                "Philadelphia", 100,
                List.of(), true);
        Trip tripWithNewData = new Trip("1", "1", Date.valueOf("2022-01-01"),
                Date.valueOf("2023-01-01"), "Belarus",
                "Minsk", 10000,
                List.of(), true);
        when(tripRepo.findById(any())).thenReturn(Optional.of(trip));
        Trip resultTripEntity = tripService.editTrip("1", tripWithNewData);
        Assertions.assertEquals(tripWithNewData, resultTripEntity);
    }

    @Test
    void editTripWhenNull() {
        Trip tripWithNewData = new Trip("1", "1", Date.valueOf("2022-01-01"),
                Date.valueOf("2023-01-01"), "Belarus",
                "Minsk", 10000,
                List.of(), true);
        Optional<Trip> nullTrip = Optional.empty();
        when(tripRepo.findById(any())).thenReturn(nullTrip);
        Trip resultTripEntity = tripService.editTrip("1", tripWithNewData);
        Assertions.assertNull(resultTripEntity);
    }


}
