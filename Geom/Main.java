package Test;
import Exceptions.GeomEx;
import Geometry2D.*;

public class Main
{
    public static void main(String[] args)
    {
        try
        {
            System.out.println("\n-------Circle-------\n");

            Figure c = new Circle(2.1);

            System.out.println("-----Area-----");
            System.out.println(c.Area());

            System.out.println("-----Show-----");
            c.Show();

            System.out.println("-----Error <r> <= 0-----");
            Figure c0 = new Circle(-2.1);

            System.out.println("-----Show-----");
            c0.Show();
        }
        catch (GeomEx e)
        {
            System.out.println("-----Processed exception-----");
        }

        try
        {
            System.out.println("\n-------Rectangle-------\n");

            Figure r = new Rectangle(3.4, 5);

            System.out.println("-----Area-----");
            System.out.println(r.Area());

            System.out.println("-----Show-----");
            r.Show();

            System.out.println("-----Error <a> <= 0-----");
            Figure r0 = new Rectangle(0, 5);

            System.out.println("-----Show-----");
            r0.Show();
        }
        catch (GeomEx e)
        {
            System.out.println("-----Processed exception-----");
        }

        try
        {
            System.out.println("\n-------Trapeze-------\n");

            Figure t = new Trapeze(3.4, 5, 2.3);

            System.out.println("-----Area-----");
            System.out.println(t.Area());

            System.out.println("-----Show-----");
            t.Show();

            System.out.println("-----Error <h> <= 0-----");
            Figure t0 = new Trapeze(3.4, 5, 0);

            System.out.println("-----Show-----");
            t0.Show();
        }
        catch (GeomEx e)
        {
            System.out.println("-----Processed exception-----");
        }

    }
}
