package org.example;

class Tiger extends Cat
{
    private static int counter = 0;
    public Tiger(String name)
    {
        super(name, 10000,1000);
        counter++;
    }
    public static int getCounter() {
        return counter;
    }

}

