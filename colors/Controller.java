package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

public class Controller
{
    String [] colors = new String [3];

    @FXML
    private RadioButton black;

    @FXML
    private RadioButton blue;

    @FXML
    private Label color_1;

    @FXML
    private Label color_2;

    @FXML
    private Label color_3;

    @FXML
    private RadioButton green;

    @FXML
    private RadioButton grey;

    @FXML
    private RadioButton pink;

    @FXML
    private RadioButton purple;

    @FXML
    private RadioButton red;

    @FXML
    private RadioButton white;

    @FXML
    private RadioButton yellow;

    ToggleGroup group_1 = new ToggleGroup();
    ToggleGroup group_2 = new ToggleGroup();
    ToggleGroup group_3 = new ToggleGroup();

    @FXML
    public  void setColor_1()
    {
        red.setToggleGroup(group_1);
        blue.setToggleGroup(group_1);
        white.setToggleGroup(group_1);

        if(red.isSelected())
        {
            colors[0] = "red";
        }
        else if(blue.isSelected())
        {
            colors[0] = "blue";
        }
        else if(white.isSelected())
        {
            colors[0] = "white";
        }

        //System.out.println(colors[0]);
    }

    @FXML
    public  void setColor_2()
    {
        black.setToggleGroup(group_2);
        pink.setToggleGroup(group_2);
        yellow.setToggleGroup(group_2);

        if(black.isSelected())
        {
            colors[1] = "black";
        }
        else if(pink.isSelected())
        {
            colors[1] = "pink";
        }
        else if(yellow.isSelected())
        {
            colors[1] = "yellow";
        }

        //System.out.println(colors[1]);
    }

    @FXML
    public  void setColor_3()
    {
        purple.setToggleGroup(group_3);
        green.setToggleGroup(group_3);
        grey.setToggleGroup(group_3);


        if(purple.isSelected())
        {
            colors[2] = "purple";
        }
        else if(green.isSelected())
        {
            colors[2] = "green";
        }
        else if(grey.isSelected())
        {
            colors[2] = "grey";
        }

        //System.out.println(colors[2]);
    }

    @FXML
    public void click()
    {
        color_1.setText(colors[0]);
        color_2.setText(colors[1]);
        color_3.setText(colors[2]);

        //System.out.println("dr");
    }
}
