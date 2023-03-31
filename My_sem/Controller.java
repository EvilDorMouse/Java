package sample;

import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


public class Controller
{
//-----------------------------------
    String res = "";
    String rec;
    String resbody;
    HttpClient client = HttpClient.newHttpClient();
    HttpResponse<String> response;
    HttpResponse<String> response0;
    JSONParser parser = new JSONParser();
    Object meta;
    JSONArray ja;

    JSONObject ja0;
    JSONObject ja1;


//----------------------------------

    @FXML
    private TextField name;
    //--------------------
    @FXML
    private CheckBox Abil;

    @FXML
    private CheckBox Sprite;

    @FXML
    private CheckBox Stat;

    @FXML
    private CheckBox Loc;

    @FXML
    private CheckBox Mov;

    @FXML
    private TextFlow text;

    @FXML
    private ImageView img_vi;

    @FXML
    private FlowPane roott;

//-------------------------------------

    @FXML
    public void click() throws IOException, InterruptedException, ParseException {
        res = name.getText();

        if(res.length() == 0)
        {
            text.getChildren().clear();
            resbody = "Name not specified";
            Text textstr = new Text(resbody);
            text.getChildren().add(textstr);
        }
        else
        {
            boolean ch = true;
            char[] ch_res;
            ch_res = res.toCharArray();

            for (int i = 0; i < ch_res.length; i++)
            {
                if (ch_res[i] == '\u0020')
                {
                    i = ch_res.length;
                    ch = false;
                }
            }

            if(ch)
            {
                res = res.toLowerCase();

                text.getChildren().clear();

                rec = "https://pokeapi.co/api/v2/pokemon/" + res + "/";
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(rec))
                        .build();

                response = client.send(request, HttpResponse.BodyHandlers.ofString());

                if(response.statusCode() == 404)
                {
                    text.getChildren().clear();
                    resbody = "Name entered incorrectly";
                    Text textstr = new Text(resbody);
                    text.getChildren().add(textstr);
                }
                else
                {
                    name.clear();
                    resbody = "";

                    if (Sprite.isSelected())
                    {
                        Img_vi_ch();
                    }

                    if (Stat.isSelected())
                    {
                        Stat_ch();
                    }

                    if (Abil.isSelected())
                    {
                        Abil_ch();
                    }

                    if (Loc.isSelected())
                    {
                        Loc_ch();
                    }

                    if (Mov.isSelected())
                    {
                        Mov_ch();
                    }

                    Text textstr = new Text(resbody);
                    text.getChildren().add(textstr);
                }
            }
            else
            {
                text.getChildren().clear();
                resbody = "Name contains a space";
                Text textstr = new Text(resbody);
                text.getChildren().add(textstr);
            }
        }
    }


    @FXML
    public void Abil_ch() throws ParseException
    {
        int l;
        resbody += "Abilities : ";

        ja0 = (JSONObject) parser.parse(response.body());
        meta = ja0.get("abilities");

        ja = (JSONArray) parser.parse(meta.toString());


        l = Math.min(ja.size(), 10);

        if(l == 0)
        {
            resbody += "non\n\n";
        }
        else
        {
            for (int i = 0; i < l; i++)
            {
                meta = ja.get(i);

                ja1 = (JSONObject) parser.parse(meta.toString());
                meta = ja1.get("ability");

                ja0 = (JSONObject) parser.parse(meta.toString());
                meta = ja0.get("name");

                if(i < l-1)
                {
                    resbody += meta.toString() + ", ";
                }
                else
                {
                    resbody += meta.toString() + "\n\n";
                }
            }
        }
    }

    @FXML
    public void Img_vi_ch() throws ParseException
    {
        ja0 = (JSONObject) parser.parse(response.body());
        meta = ja0.get("sprites");

        ja1 = (JSONObject) parser.parse(meta.toString());
        meta = ja1.get("front_default");

        Image image = new Image(meta.toString());

        img_vi = new ImageView(image);

        double h = 200, w=200;

        img_vi.setFitHeight(h);
        img_vi.setFitWidth(w);

        img_vi.setPreserveRatio(true);

        roott.getChildren().clear();
        roott.getChildren().add(img_vi);
    }

    @FXML
    public void Stat_ch() throws ParseException
    {
        int l;
        resbody += "Stats : ";

        ja0 = (JSONObject) parser.parse(response.body());
        meta = ja0.get("stats");

        ja = (JSONArray) parser.parse(meta.toString());


        l = Math.min(ja.size(), 10);

        if(l == 0)
        {
            resbody += "non\n\n";
        }
        else
        {
            for (int i = 0; i < l; i++)
            {
                meta = ja.get(i);

                ja1 = (JSONObject) parser.parse(meta.toString());

                resbody += ja1.get("base_stat") + " -> ";

                meta = ja1.get("stat");

                ja0 = (JSONObject) parser.parse(meta.toString());
                meta = ja0.get("name");

                if(i < l-1)
                {
                    resbody += meta.toString() + "\n";
                }
                else
                {
                    resbody += meta.toString() + "\n\n";
                }
            }
        }
    }

    @FXML
    public void Loc_ch() throws IOException, InterruptedException, ParseException
    {
        int l;
        resbody += "Locations : ";

        ja0 = (JSONObject) parser.parse(response.body());
        meta = ja0.get("location_area_encounters");

        HttpRequest request0 = HttpRequest.newBuilder()
                .uri(URI.create(meta.toString() + "/"))
                .build();

        response0 = client.send(request0, HttpResponse.BodyHandlers.ofString());

        ja = (JSONArray) parser.parse(response0.body());

        l = Math.min(ja.size(), 10);

        if(l == 0)
        {
            resbody += "non\n\n";
        }
        else
        {
            for (int i = 0; i < l; i++)
            {
                meta = ja.get(i);

                ja1 = (JSONObject) parser.parse(meta.toString());
                meta = ja1.get("location_area");

                ja0 = (JSONObject) parser.parse(meta.toString());
                meta = ja0.get("name");

                if(i < l-1)
                {
                    resbody += meta.toString() + ", ";
                }
                else
                {
                    resbody += meta.toString() + "\n\n";
                }
            }
        }
    }

    @FXML
    public void Mov_ch() throws ParseException
    {
        int l;
        resbody += "Moves : ";

        ja0 = (JSONObject) parser.parse(response.body());
        meta = ja0.get("moves");

        ja = (JSONArray) parser.parse(meta.toString());

        l = Math.min(ja.size(), 10);

        if(l == 0)
        {
            resbody += "non\n\n";
        }
        else
        {
            for(int i = 0; i < l; i++)
            {
                meta = ja.get(i);

                ja1 = (JSONObject) parser.parse(meta.toString());
                meta = ja1.get("move");

                ja0 = (JSONObject) parser.parse(meta.toString());
                meta = ja0.get("name");

                if(i < l-1)
                {
                    resbody += meta.toString() + ", ";
                }
                else
                {
                    resbody += meta.toString() + "\n\n";
                }
            }
        }
    }
}
