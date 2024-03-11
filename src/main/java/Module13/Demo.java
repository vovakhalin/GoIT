package Module13;

import Module13.Customer.Address;
import Module13.Customer.Company;
import Module13.Customer.CustomerResponseDto;
import Module13.Customer.Geo;
import com.google.gson.GsonBuilder;
import lombok.SneakyThrows;
import com.google.gson.Gson;
import lombok.Builder;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

import static jdk.internal.classfile.Classfile.build;

public class Demo {
    public static final String BASE_URL = "https://jsonplaceholder.typicode.com";
    @SneakyThrows
    public static void main(String[] args) {
        HttpClient httpClient = HttpClient.newHttpClient();
        Gson gsonMapper = new GsonBuilder().setPrettyPrinting().create();

        CustomerResponseDto customerResponseDto = new CustomerResponseDto(
                15L,
                "Mukola",
                List.of(
                        new Address("Poloyva", "15", "Zhytomyr", "121165",
                                List.of(
                                        new Geo(123325, 15456877)
                                )
                        )
                ),
                "1223565585",
                "https://jsonplaceholder.typicode.com/",
                List.of(
                        new Company("Coca-cola","Hello world", "sdfsdg")
                )

        );

        String customerJson = gsonMapper.toJson(customerResponseDto);
//        System.out.println(customerJson);

        HttpRequest createCustomerRequest = HttpRequest.newBuilder(new URI(BASE_URL + "/users"))
                .POST(HttpRequest.BodyPublishers.ofString(customerJson))
                .header("accept", "application/json")
                .header("Content-type", "application/json")
                .build();
        HttpResponse<String> customerResponse = httpClient.send(createCustomerRequest, HttpResponse.BodyHandlers.ofString());
        System.out.println("customerResponse.statusCode() = " + customerResponse.statusCode());
        CustomerResponseDto customerDto = gsonMapper.fromJson(customerResponse.body(), CustomerResponseDto.class);
        System.out.println(customerDto);
    }
}
