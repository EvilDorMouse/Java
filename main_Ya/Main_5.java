import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.json.simple.parser.*;
import org.json.simple.*;

public class Main_5
{

    public static void main(String[] args) throws IOException, InterruptedException, ParseException
    {
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://geocode-maps.yandex.ru/1.x/?format=json&apikey=78bd8723-998a-4b1b-bdc2-4b3b881830aa&results=1&geocode=Москва,улица+Петровка,дом+38"))
                .build();


        HttpResponse<String> response;
        //response = client.send(request, HttpResponse.BodyHandlers.ofFile(Paths.get("body.json")));
        response = client.send(request, HttpResponse.BodyHandlers.ofString());

        //System.out.println("Response:" + response.body());

        JSONParser parser = new JSONParser();
        Object meta;
        JSONArray ja;

        JSONObject ja0;
        JSONObject ja1;

        /*
        meta = ja.get();
        ja = (JSONObject) parser.parse(meta.toString());
        System.out.println(ja.get());
        System.out.println("----------------------------------------------");
        */

        ja0 = (JSONObject) parser.parse(response.body());
        //System.out.println(ja0.get("response"));

        meta = ja0.get("response");
        ja1 = (JSONObject) parser.parse(meta.toString());
        //System.out.println(ja1.get("GeoObjectCollection"));

        meta = ja1.get("GeoObjectCollection");
        ja0 = (JSONObject) parser.parse(meta.toString());
        //System.out.println(ja0.get("featureMember"));

        meta = ja0.get("featureMember");
        ja = (JSONArray) parser.parse(meta.toString());
        //System.out.println(ja.get(0));

        meta = ja.get(0);
        ja0 = (JSONObject) parser.parse(meta.toString());
        //System.out.println(ja0.get("GeoObject"));

        meta = ja0.get("GeoObject");
        ja1 = (JSONObject) parser.parse(meta.toString());
        //System.out.println(ja1.get("metaDataProperty"));

        meta = ja1.get("metaDataProperty");
        ja0 = (JSONObject) parser.parse(meta.toString());
        //System.out.println(ja0.get("GeocoderMetaData"));

        meta = ja0.get("GeocoderMetaData");
        ja1 = (JSONObject) parser.parse(meta.toString());
        //System.out.println(ja1.get("Address"));

        meta = ja1.get("AddressDetails");
        ja0 = (JSONObject) parser.parse(meta.toString());

        meta = ja0.get("Country");
        ja1 = (JSONObject) parser.parse(meta.toString());

        meta = ja1.get("AdministrativeArea");
        ja0 = (JSONObject) parser.parse(meta.toString());

        meta = ja0.get("Locality");
        ja1 = (JSONObject) parser.parse(meta.toString());

        meta = ja1.get("Thoroughfare");
        ja0 = (JSONObject) parser.parse(meta.toString());

        meta = ja0.get("Premise");
        ja1 = (JSONObject) parser.parse(meta.toString());
        System.out.println(ja1.get("PostalCode"));

        meta = ja1.get("PostalCode");
        ja0 = (JSONObject) parser.parse(meta.toString());
        System.out.println(ja0.get("PostalCodeNumber"));
    }
}
