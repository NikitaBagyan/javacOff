package src.main.Week6.Homework;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class WebApiCatFacts {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static CatFact getFact() {
        HttpClient httpClient = HttpClient.newHttpClient();

        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create("https://catfact.ninja/fact"))
                .GET()
                .build();
        try {
            HttpResponse<String> response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());

            CatFact catFact = objectMapper.readValue(response.body(), CatFact.class);
            return catFact;

        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
