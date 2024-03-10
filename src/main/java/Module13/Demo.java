package Module13;

import Module13.Customer.Address;
import Module13.Customer.CustomerResponseDto;
import Module13.Customer.Geo;
import lombok.SneakyThrows;
import com.google.gson.Gson;
import lombok.Builder;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

import static jdk.internal.classfile.Classfile.build;
//import Module13.Customer.CustomerRequestDto;

public class Demo {
    public static final String BASE_URL = "https://jsonplaceholder.typicode.com/users";
    @SneakyThrows
    public static void main(String[] args) {
        HttpClient httpClient = HttpClient.newHttpClient();

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
                List.of("Coca-cola","Hello world", "sdfsdg")
        );


    }
}
