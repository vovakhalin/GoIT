package TelegramBot.Client;

import TelegramBot.Responce.PrivatBankResponceApiDto;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpResponse;
import java.util.List;
import java.net.http.HttpRequest;
import java.net.URI;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.GsonBuilder;

import static TelegramBot.BotConstants.PRIVAT_API;

public class PrivetClient {
    private HttpClient client = HttpClient.newHttpClient();
    private ObjectMapper objectMapper = new ObjectMapper();
    public static List<PrivatBankResponceApiDto> currency;
    public static void getDefaultCurrency() {
                Gson gsonMapper = new GsonBuilder().setPrettyPrinting().create();
                HttpClient httpClient = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(PRIVAT_API))
                .header("Content-Type", "application/json")
                .GET()
                .build();
        try {
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            currency = gsonMapper.fromJson(response.body(), new TypeToken<List<PrivatBankResponceApiDto>>() {}.getType());;
            System.out.println(currency.getFirst());
        } catch (IOException | InterruptedException e) {
            System.err.println("Error sending GET request: " + e.getMessage());
        }

    }
}
