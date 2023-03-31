import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Path;
import java.nio.file.Paths;


public class Main_6
{

    public static void main(String[] args) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://static-maps.yandex.ru/1.x/?ll=149.125531,-35.306907&z=3&l=sat"))
                .build();

        // response body это файл
        HttpResponse<Path> response;
        response = client.send(request, HttpResponse.BodyHandlers.ofFile(Paths.get("Australia.png")));

        System.out.println("Response in file:" + response.statusCode());
    }
}