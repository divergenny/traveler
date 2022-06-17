package by.divergenny.traveler.web;

import by.divergenny.traveler.domain.Trip;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

@RestController
@RequestMapping("/http")
public class HttpController {
    private static final String POST_API_URL = "http://localhost:8088/trips/addTrip";

    @PostMapping("callTrip")
    public void callAddTrip() throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .POST(HttpRequest.BodyPublishers.ofString(""))
                .header("Content-Type", "text/plain;charset=UTF-8")
                .uri(URI.create(POST_API_URL))
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        ObjectMapper mapper = new ObjectMapper();
        List<Trip> trips = mapper.readValue(response.body(), new TypeReference<List<Trip>>() {
        });

        trips.forEach(System.out::println);
    }
}
