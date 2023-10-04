package org.example;

class Cat extends Animal {
    private static int counter = 0;

    public Cat(String name) {
        super(name, 200, 0);
        counter++;
    }
    protected Cat(String name, int runLimit, int swimLimit) {
        super(name, 20000,2000);
        counter++;
    }
        public static int getCounter() {
        return counter;
    }
}
