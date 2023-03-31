package Geometry2D;

import Exceptions.GeomEx;

public class Trapeze implements Figure
{
    double a;
    double b;
    double h;

    public Trapeze (double na, double nb, double nh) throws GeomEx
    {
        if (na <= 0) throw new GeomEx(2);
        if (nb <= 0) throw new GeomEx(3);
        if (nh <= 0) throw new GeomEx(4);
        a = na;
        b= nb;
        h= nh;
    }

    public double Area()
    {
        return 0.5 * (a + b) * h;
    }

    public void Show()
    {
        System.out.println("Figure: Trapeze \n" + "Characters: a = " + a + ", b = " + b + ", h = " + h + "\nArea: " + Area());
    }
}