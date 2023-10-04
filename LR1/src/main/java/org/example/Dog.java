package org.example;

class Dog extends Animal
{
    private static int counter = 0;
    public Dog(String name)
    {
        super(name, 500, 10);
        counter++;
    }
    public static int getCounter() {
        return counter;
    }

}
