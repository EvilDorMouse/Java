package Exceptions;

public class GeomEx extends Exception
{
    public GeomEx(int mean)
    {
        switch (mean)
        {
            case 1 -> System.out.println("Radius <r> <= 0");
            case 2 -> System.out.println("Side <a> <= 0");
            case 3 -> System.out.println("Side <b> <= 0");
            case 4 -> System.out.println("Height <h> <= 0");
            default -> System.out.println("Untreated exception");
        }
    }
}
