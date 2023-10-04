package org.example;

abstract class Fish extends Animal
{
    protected static int length;

    private static int counter = 0;

    public Fish(String name)
    {
        super(name,0,100000);
        counter++;
    }

    public void FishLength()
    {
        System.out.println("Длина рыбы под названием - " + name + " " + length);
    }

    @Override
    public void run(int distance) {
        System.out.println(name + " не бегает");
    }

    public static int getCounter() {
        return counter;
    }
}
