package by.divergenny.traveler.web;

import by.divergenny.traveler.domain.Trip;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

public class Http {
    private static final String POST_API_URL = "http://localhost:8088/trips/addTrip";

    public static void main(String[] args) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .POST(HttpRequest.BodyPublishers.ofString(""))
                .header("Content-Type", "text/plain;charset=UTF-8")
                .uri(URI.create(POST_API_URL))
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        ObjectMapper mapper = new ObjectMapper();
        List<Trip> trips = mapper.readValue(response.body(), new TypeReference<List<Trip>>() {});

        trips.forEach(System.out::println);

    }
}
/*


{
  "id": "10",
  "userid": "10",
  "dateStart": "2022-06-17T09:27:43.012Z",
  "dateEnd": "2022-06-17T09:27:43.012Z",
  "country": "Uzbekistan",
  "city": "Tashkent",
  "budget": 10000,
  "expenses": [
    "No"
  ],
  "lookingForATravelingCompanion": true
}

1) отправляется запрос на наш /addTrip
2) в методе public Trip add(Trip trip) { отправляем запрос на emailService
3) emailService отправляет сообщение

тебе нужно создать метод, который создает запрос

 */