package org.example;

public class Main {
    public static void main(String[] args) {
        Animal[] animals =
                {
                        new Cat("Barsik"),
                        new Dog("Bobik"),
                        new Tiger("Sherhan"),
                        new Щука("Щука"),
                        new Окунь("Окунь"),
                        new Лосось("Лосось")
                };
        for (Animal animal : animals) {
            animal.run(400);
            animal.swim(1500);
        }

        System.out.println("Создано кошачьих: " + Cat.getCounter());
        System.out.println("Создано рыб: " + Fish.getCounter());
        System.out.println("Создано собачьих: " + Dog.getCounter());
        System.out.println("Создано тигров: " + Tiger.getCounter());
        System.out.println("Создано животных: " + Animal.getCount());

        ((Fish)animals[4]).FishLength();
        ((Окунь)animals[4]).ves();
    }
}
