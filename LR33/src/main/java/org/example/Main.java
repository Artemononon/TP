package org.example;

public class Main {    public static void main(String[] args) {
    String[][] array =
            {
                    {"2", "2", "2", "2"},
                    {"2", "2", "2", "2"},
                    {"2", "2", "2", "2"},
                    {"2", "2", "2", "2."}
            };

    double sum = 0;
    boolean hasNumberFormatException = false;

    for (int i = 0; i < array.length; i++)
    {
        for (int j = 0; j < array[i].length; j++)
        {
            try
            {
                if (array.length != 4 || array[j].length != 4)
                {
                    throw new MyArraySizeException();
                }

                double value = Double.valueOf(array[i][j]);


            }
            catch (NumberFormatException e)
            {
                throw new MyArrayDataException(i,j,array [i][j]);
            }
        }
    }
    for (int i = 0; i < array.length; i++)
    {
        for (int j = 0; j < array[i].length; j++)
        {
            try
            {
                double value = Double.valueOf(array[i][j]);
                sum += value;
                if (!isHamming(value))
                {
                    throw new MyHammingException(i, j, array[i][j]);
                }
            }
            catch (MyHammingException e)
            {
                e.printStackTrace();
            }
        }
    }
    if (!hasNumberFormatException) {
        System.out.println("Сумма чисел в массиве: " + sum);
    }
}
    public static boolean isHamming(double number)
    {
        if (number <= 1 || number > 1000)
        {
            return false;
        }
        while (number % 2 == 0)
        {
            number /= 2;
        }
        while (number % 3 == 0)
        {
            number /= 3;
        }
        while (number % 5 == 0)
        {
            number /= 5;
        }
        return number == 1;

    }
}











