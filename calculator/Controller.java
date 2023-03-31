package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Controller
{

    //--------------------------------------------------------

    @FXML
    private TextField input_panel;
    @FXML
    private Label get_answer;

    boolean ch = true;

    int pos = 0;

    double val1 = Double.NaN;
    double val2 = Double.NaN;
    double ans = 0;
    //char[] input_p_count = new char[100];

    @FXML
    public void click_del()
    {
        if(pos != 0)
        {
            if(input_panel.getText(pos - 1, pos).equals(" "))
            {
                input_panel.deleteText(pos-3, pos);
                pos-=3;
            }
            else
            {
                input_panel.deleteText(pos - 1, pos);
                pos--;
            }
        }
    }

    @FXML
    void click_plus()
    {
        pos+=3;
        input_panel.appendText(" + ");
    }

    //input_panel.clear();

    @FXML
    public void click_dot()
    {
        pos++;
        input_panel.appendText(".");
    }

    @FXML
    public void click_minus()
    {
        pos+=3;
        input_panel.appendText(" - ");
    }

    @FXML
    public void click_division()
    {
        pos+=3;
        input_panel.appendText(" / ");
    }

    @FXML
    public void click_multiply()
    {
        pos+=3;
        input_panel.appendText(" * ");
    }

    @FXML
    public void click_Equally() {
        pos = 0;
        ans = 0;
        val1 = Double.NaN;
        val2 = Double.NaN;

        My_mass();

        input_panel.clear();
    }

    @FXML
    public void click_b0()
    {
        pos++;
        input_panel.appendText("0");
    }

    @FXML
    public void click_b1()
    {
        pos++;
        input_panel.appendText("1");
    }

    @FXML
    public void click_b2()
    {
        pos++;
        input_panel.appendText("2");
    }

    @FXML
    public void click_b3()
    {
        pos++;
        input_panel.appendText("3");
    }

    @FXML
    public void click_b4()
    {
        pos++;
        input_panel.appendText("4");
    }

    @FXML
    public void click_b5()
    {
        pos++;
        input_panel.appendText("5");
    }

    @FXML
    public void click_b6()
    {
        pos++;
        input_panel.appendText("6");
    }

    @FXML
    public void click_b7()
    {
        pos++;
        input_panel.appendText("7");
    }

    @FXML
    public void click_b8()
    {
        pos++;
        input_panel.appendText("8");
    }

    @FXML
    public void click_b9()
    {
        pos++;
        input_panel.appendText("9");
    }

    public void My_mass() {
        String end = " ";
        String str = input_panel.getText() + end;

        char[] cstr;
        cstr = str.toCharArray();
        System.out.println(cstr);

        char[] m = new char[cstr.length];
        char[] n;

        char operation = '\0';

        int size = 0;

        String res;

        for(int i = 0; i < cstr.length; i++)
        {
            if (cstr[i] != ' ')
            {
                m[size] = cstr[i];
                size ++;
            }
            else
            {
                n = new char[size];

                for(int j = 0; j < size; j++)
                {
                    n[j] = m[j];
                }

                res = new String(n);
                size = 0;

                if(Double.isNaN(val1))
                {
                    val1 = Double.parseDouble(res);
                    System.out.println("-----------------val1");
                    System.out.println(val1);
                }
                else
                {
                    val2 = Double.parseDouble(res);
                    System.out.println("-----------------val2");
                    System.out.println(val2);
                }

                if (!Double.isNaN(val1) && !Double.isNaN(val2))
                {
                    val1 = calc(val1, operation, val2);
                    System.out.println("-----------------calc");
                    System.out.println(val1);
                }

                if(cstr.length - i > 2)
                {
                    i++;
                    operation = cstr[i];
                    i ++;

                    System.out.println(operation);
                }
            }
        }

        if (ch)
        {
            get_answer.setText(String.valueOf(val1));
        }
        else
        {
            get_answer.setText("Division by zero");
        }

    }

    public double calc(double v1, char op, double v2)
    {
        char[] Symbol = {'+', '-', '*', '/'};

        if (op == Symbol[0])
        {
            ans = v1 + v2;
        }
        if (op == Symbol[1])
        {
            ans = v1 - v2;
        }
        if (op == Symbol[2])
        {
                ans = v1 * v2;
        }
        if (op == Symbol[3])
        {
            if (v2 == 0)
            {
                ch = false;
            }
            else
            {
                ans = v1 / v2;
            }
        }

        return ans;
    }
}
