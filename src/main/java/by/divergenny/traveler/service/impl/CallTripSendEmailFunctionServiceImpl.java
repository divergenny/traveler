package by.divergenny.traveler.service.impl;

import by.divergenny.traveler.domain.Trip;
import by.divergenny.traveler.domain.User;
import by.divergenny.traveler.dto.MessageDto;
import by.divergenny.traveler.service.SendService;
import by.divergenny.traveler.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.client.utils.URIBuilder;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
@AllArgsConstructor
@Slf4j
public class CallTripSendEmailFunctionServiceImpl implements SendService {
    private static final String POST_API_URL = "http://localhost:8087/trips/email";
    //http://localhost:8087/trips/email?email=vpodkovyrkin%40exadel.com

    private final UserService userService;

    @Override
    public String callSendEmailOfTrip(Trip trip) {
        User user = userService.getById(trip.getUserid());
        MessageDto messageDto = new MessageDto(user.getFirstName(),
                user.getEmail(),
                "",
                user.getCountry(),
                trip.getDateStart(),
                trip.getDateEnd());

        ObjectMapper mapper = new ObjectMapper();
        String messageDtoJson = "";
        try {
            messageDtoJson = mapper.writeValueAsString(messageDto);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        String response = "";
        try {
            HttpClient client = HttpClient.newHttpClient();
            URI uri = new URIBuilder(POST_API_URL)
                    .build();
            HttpRequest request = HttpRequest.newBuilder()
                    .POST(HttpRequest.BodyPublishers.ofString(messageDtoJson))
                    .uri(uri)
                    .build();
            response = client.send(request, HttpResponse.BodyHandlers.ofString()).body();
        } catch (InterruptedException | URISyntaxException | IOException e) {
            log.error("Method callSendEmailOfTrip, tripInSystem -> {}, error -> {}", trip, e);
        }
        return response;
    }
}
