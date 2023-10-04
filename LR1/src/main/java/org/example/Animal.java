package org.example;

class Animal
{
    protected String name;
    protected int runLimit;
    protected int swimLimit;


    protected static int count;

    public Animal(String name, int runLimit, int swimLimit)
    {
        this.name = name;
        this.runLimit = runLimit;
        this.swimLimit = swimLimit;
        count++;
    }

    public void run(int distance)
    {
        if (distance <= runLimit)
        {
            System.out.println(name + " пробежал " + distance + " м");
        }
        else
        {
            System.out.println(name + " не может пробежать такую дистанцию");
        }
    }

    public void swim(int distance)
    {
        if (distance <= swimLimit)
        {
            System.out.println(name + " проплыл " + distance + " м");
        }
        else
        {
            System.out.println(name + " не может проплыть такую дистанцию");
        }
    }



    public static int getCount()
    {
        return count;
    }

}
