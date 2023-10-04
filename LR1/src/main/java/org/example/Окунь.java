package org.example;
class Окунь extends Fish
{
    protected int vess;
    public Окунь(String name)
    {
        super(name);
        length = 80;
        vess = 12;
    }

    public void ves() {
        System.out.println("Вес рыбы с названием " + name + " " + vess);
    }
}
