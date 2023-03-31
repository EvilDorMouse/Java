import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Path;
import java.nio.file.Paths;


public class Main_8
{

    public static void main(String[] args) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://static-maps.yandex.ru/1.x/?ll=86.880133,54.173048&z=7&l=map&pl=86.086847,55.355198,86.162243,54.663609,87.136053,53.757553,87.955989,52.953495&pt=86.086847,55.355198,pm2rdm1~86.162243,54.663609,pm2rdm2~87.136053,53.757553,pm2rdm3~87.955989,52.953495,pm2rdm4"))
                .build();


        HttpResponse<Path> response;
        response = client.send(request, HttpResponse.BodyHandlers.ofFile(Paths.get("Kemerovo_Route.png")));

        System.out.println("Response in file:" + response.statusCode());
    }
}
