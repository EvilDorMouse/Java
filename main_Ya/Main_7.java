import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Path;
import java.nio.file.Paths;


public class Main_7
{

    public static void main(String[] args) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://static-maps.yandex.ru/1.x/?ll=86.113742,55.353408&z=12&l=map&pt=86.060110,55.344206,pm2blm1~86.071729,55.375501,pm2rdm3~86.125789,55.388589,pm2wtm2~86.182276,55.348824,pm2gnm4"))
                .build();


        HttpResponse<Path> response;
        response = client.send(request, HttpResponse.BodyHandlers.ofFile(Paths.get("Kemerovo.png")));

        System.out.println("Response in file:" + response.statusCode());
    }
}
