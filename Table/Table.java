public class Table
{
    int[][] numbers;

    Table(int rows, int cols)
    {
        numbers = new int[rows][cols];

        for (int i = 0; i < rows; i++)
        {
            for(int j = 0; j <cols; j++)
            numbers[i][j] = 0;
        }
    }

    void get_values(int row, int col)
    {
        System.out.println(numbers[row][col]);
    }

    void set_value(int row, int col, int value)
    {
        numbers[row][col] = value;
    }

    void n_rows()
    {
        System.out.println(numbers.length);
    }

    void n_cols()
    {
        System.out.println(numbers[0].length);
    }

    void print()
    {
        for (int i = 0; i < numbers.length; i++)
        {
            for (int j = 0; j < numbers[0].length; j++)
            {
                System.out.print(numbers[i][j] + " ");
            }

            System.out.println();
        }
    }

    void average()
    {
        int sum = 0;

        for (int i = 0; i < numbers.length; i++)
        {
            for (int j = 0; j < numbers[0].length; j++)
            {
                sum += numbers[i][j];
            }
        }

        System.out.println((float)sum/numbers.length/numbers[0].length);
    }
}