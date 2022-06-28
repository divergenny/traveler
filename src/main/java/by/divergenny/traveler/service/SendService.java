package by.divergenny.traveler.service;

import by.divergenny.traveler.domain.Trip;

public interface SendService {
    String callSendEmailOfTrip(Trip trip);
}
