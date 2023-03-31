package Geometry2D;

import Exceptions.GeomEx;

public class Circle implements Figure
{
    double r;

    public Circle (double nr) throws GeomEx
    {
        if(nr <= 0) throw new GeomEx(1);
        r = nr;
    }

    public double Area()
    {
        return 2 * 3.14 * r;
    }

    public void Show()
    {
        System.out.println("Figure: Circle\n" + "Characters: r = " + r + "\nArea: " + Area());
    }
}