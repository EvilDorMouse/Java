public class Main 
{
    public static void main(String[] args)
    {
        OddEvenSeparator n = new OddEvenSeparator();

        n.add_number(3);
        n.add_number(22);
        n.add_number(11);
        n.add_number(57);
        n.add_number(12);
        n.add_number(44);
        n.add_number(9);

        n.odd();
        n.even();
    }
}