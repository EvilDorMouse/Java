public class Main
{
    public static void main(String[] args) 
    {
        Table t = new Table(2, 3);

        System.out.println("-----get_values-----");
        t.get_values(0, 2);

        t.set_value(0, 0, 3);
        t.set_value(0, 1, 5);
        t.set_value(0, 2, 8);
        t.set_value(1, 0, 5);

        System.out.println("-----n_rows-----");
        t.n_rows();
        System.out.println("-----n_cols-----");
        t.n_cols();
        System.out.println("-----print-----");
        t.print();
        System.out.println("-----average-----");
        t.average();
    }
}