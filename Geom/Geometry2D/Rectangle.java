package Geometry2D;

import Exceptions.GeomEx;

public class Rectangle implements Figure
{
    double a;
    double b;

    public Rectangle (double na, double nb) throws GeomEx
    {
        if (na <= 0) throw new GeomEx(2);
        if (nb <= 0) throw new GeomEx(3);
        a = na;
        b= nb;
    }

    public double Area()
    {
        return a * b;
    }

    public void Show()
    {
        System.out.println("Figure: Rectangle \n" + "Characters: a = " + a +", b = " + b + "\nArea: " + Area());
    }
}