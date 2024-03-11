package Module13;

import Module13.Customer.Address;
import Module13.Customer.Company;
import Module13.Customer.CustomerResponseDto;
import Module13.Customer.Geo;
import com.google.gson.GsonBuilder;
import lombok.SneakyThrows;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;


import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Collectors;


public class Demo {
    public static final String BASE_URL = "https://jsonplaceholder.typicode.com";
    public static final String BASE_COMMENT_URL = "https://jsonplaceholder.typicode.com";
    @SneakyThrows
    public static void main(String[] args) {

        Gson gsonMapper = new GsonBuilder().setPrettyPrinting().create();

        /* створення об'єкта */
        CustomerResponseDto customerResponseDto = new CustomerResponseDto(
                15L,
                "Mukola",
                "Igle",
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


        /* оновлення об'єкта */
            CustomerResponseDto updatedDto = new CustomerResponseDto(
                    customerResponseDto.id(),
                    customerResponseDto.name(),
                    customerResponseDto.username(),
                    customerResponseDto.address(),
                    "11111111", //
                    customerResponseDto.website(),
                    customerResponseDto.company()
            );
            String updateJson = gsonMapper.toJson(updatedDto);

//        addUser(customerJson);
//        updateUser(updateJson);
//        deleteUserById(10L);
//        getAllUsers();
//        getUserById(8L);
//        getUserByUsername("Maxime_Nienow");
//        getLastPostByUserId(4L);
//        getOpenTasksByUserId(2L);

    }
    public static void addUser(String user) {
        HttpClient httpClient = HttpClient.newHttpClient();
        String apiUrl = BASE_URL + "/users";


        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(apiUrl))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(user))
                .build();

        try {
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println("Response Code: " + response.statusCode());
            System.out.println("Response Body:");
            System.out.println(response.body());
        } catch (Exception e) {
            System.err.println("Error sending POST request: " + e.getMessage());
        }

    }
    public static void updateUser(String user) {
        HttpClient httpClient = HttpClient.newHttpClient();
        String apiUrl = BASE_URL + "/users";


                    HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(apiUrl))
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(user))
                    .build();

            try {
                HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
                System.out.println("Response Code: " + response.statusCode());
                System.out.println("Response Body:");
                System.out.println(response.body());
            } catch (Exception e) {
                System.err.println("Error sending POST request: " + e.getMessage());
            }

    }
    public static void deleteUserById(Long id){
        HttpClient httpClient = HttpClient.newHttpClient();
        String apiUrl = BASE_URL + "/users/" + id;

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(apiUrl))
                .header("Content-Type", "application/json")
                .DELETE()
                .build();

        try {
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            int statusCode = response.statusCode();
            if (statusCode >= 200 && statusCode < 300) {
                System.out.println("User with ID " + id + " deleted successfully.");
            } else {
                System.out.println("Failed to delete user with ID " + id + ". Response Code: " + statusCode);
            }
        } catch (IOException | InterruptedException e) {
            System.err.println("Error sending DELETE request: " + e.getMessage());
        }

    }

    public static void getAllUsers() {
        HttpClient httpClient = HttpClient.newHttpClient();
        String apiUrl = BASE_URL + "/users";

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(apiUrl))
                .header("Content-Type", "application/json")
                .GET()
                .build();

        try {
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            int statusCode = response.statusCode();
                System.out.println("All users:");
                System.out.println(response.body());
        } catch (IOException | InterruptedException e) {
            System.err.println("Error sending GET request: " + e.getMessage());
        }
    }
    public static void getUserById(Long id) {
        HttpClient httpClient = HttpClient.newHttpClient();
        String apiUrl = BASE_URL + "/users/" + id;

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(apiUrl))
                .header("Content-Type", "application/json")
                .GET()
                .build();

        try {
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println("User with ID " + id + ":");
            System.out.println(response.body());

        } catch (IOException | InterruptedException e) {
            System.err.println("Error sending GET request: " + e.getMessage());
        }
    }
    public static void getUserByUsername(String username) {
        HttpClient httpClient = HttpClient.newHttpClient();
        String apiUrl = BASE_URL + "/users?username=" + username;

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(apiUrl))
                .header("Content-Type", "application/json")
                .GET()
                .build();

        try {
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

                System.out.println("User with username " + username + ":");
                System.out.println(response.body());

        } catch (IOException | InterruptedException e) {
            System.err.println("Error sending GET request: " + e.getMessage());
        }
    }
    public static void getLastPostByUserId(Long id) {
        HttpClient httpClient = HttpClient.newHttpClient();
        Gson gsonMapper = new Gson();
        String userPostsUrl = BASE_COMMENT_URL + "/users/" + id + "/posts";

        HttpRequest userPostsRequest  = HttpRequest.newBuilder()
                .uri(URI.create(userPostsUrl))
                .header("Content-Type", "application/json")
                .GET()
                .build();

        try {
            HttpResponse<String> userPostsResponse = httpClient.send(userPostsRequest, HttpResponse.BodyHandlers.ofString());
            List<Post> userPosts = gsonMapper.fromJson(userPostsResponse.body(), new TypeToken<List<Post>>() {}.getType());
            Post lastPost = userPosts.stream()
                    .max((p1, p2) -> p1.getId().compareTo(p2.getId()))
                    .orElse(null);

            if (lastPost != null) {
                Long lastPostId = lastPost.getId();

                String postCommentsUrl = BASE_URL + "/posts/" + lastPostId + "/comments";
                HttpRequest postCommentsRequest = HttpRequest.newBuilder()
                        .uri(URI.create(postCommentsUrl))
                        .header("Content-Type", "application/json")
                        .GET()
                        .build();

                HttpResponse<String> postCommentsResponse = httpClient.send(postCommentsRequest, HttpResponse.BodyHandlers.ofString());

                List<Comment> postComments = gsonMapper.fromJson(postCommentsResponse.body(), new TypeToken<List<Comment>>() {}.getType());

                String fileName = "user-" + id + "-post-" + lastPostId + "-comments.json";
                Path filePath = Path.of("src/main/java/Module13/files/" + fileName);
                FileWriter fileWriter = new FileWriter(filePath.toFile());

                gsonMapper.toJson(postComments, fileWriter);
                fileWriter.flush();
                fileWriter.close();

            } else {
                System.out.println("No posts found for user " + id);
            }
        } catch (IOException | InterruptedException e) {
            System.err.println("Error sending GET request: " + e.getMessage());
        }
    }
    public static void getOpenTasksByUserId(Long id) {
        HttpClient httpClient = HttpClient.newHttpClient();
        Gson gsonMapper = new Gson();

        String userTodosUrl = BASE_COMMENT_URL + "/users/" + id + "/todos";
        HttpRequest userTodosRequest  = HttpRequest.newBuilder()
                .uri(URI.create(userTodosUrl))
                .header("Content-Type", "application/json")
                .GET()
                .build();

        try {
            HttpResponse<String> userTodosResponse = httpClient.send(userTodosRequest, HttpResponse.BodyHandlers.ofString());
            List<Todo> userTodos = gsonMapper.fromJson(userTodosResponse.body(), new TypeToken<List<Todo>>() {}.getType());

            List<Todo> openTasks = userTodos.stream()
                    .filter(todo -> !todo.isCompleted())
                    .collect(Collectors.toList());

            if (!openTasks.isEmpty()) {
                System.out.println("Open tasks for user with id " + id + ":");
                openTasks.forEach(System.out::println);
            } else {
                System.out.println("No open tasks found for user with id " + id);
            }
        } catch (IOException | InterruptedException e) {
            System.err.println("Error sending GET request: " + e.getMessage());
        }
    }
}
