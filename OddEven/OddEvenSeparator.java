public class OddEvenSeparator
{
    int[] numbers;

    OddEvenSeparator()
    {
        numbers = new int [0];
    }

    void add_number(int num)
    {
        int[] new_m = new int [numbers.length + 1];

        for (int i = 0; i < numbers.length; i++)
        {
            new_m[i] = numbers[i];
        }
        new_m[numbers.length] = num;

        numbers = new_m;
    }

    void even()
    {
        System.out.println("-----even-----");

        for (int i = 0; i < numbers.length; i++)
        {
            if(numbers[i] % 2 == 0)
            {
                System.out.println(numbers[i]);
            }
        }
        
    }

    void odd()
    {
        System.out.println("-----odd-----");

        for (int i = 0; i < numbers.length; i++)
        {
            if(numbers[i] % 2 != 0)
            {
                System.out.println(numbers[i]);
            }
        }
        
    }
}