package org.example;
import java.util.ArrayList;


public class Box<T extends Fruit> {
    private ArrayList<T> fruits;
    private boolean hasLemon;
    public Box(T... fruits) {
        this.fruits = new ArrayList<>();
        for (T fruit : fruits) {
            this.fruits.add(fruit);
            if (fruit instanceof Lemon) {
                hasLemon = true;
            }
        }
    }

    public void addFruit(T fruit) {
        fruits.add(fruit);
    }

    public void addFruits(int count) {
        if (fruits.isEmpty()) {
            return;
        }

        for (int i = 0; i < count; i++) {

            try {
                addFruit((T) fruits.get(0).getClass().newInstance());
            } catch (InstantiationException e) {
                throw new RuntimeException(e);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public int getWeight() {
        int weight = 0;
        for (T fruit : fruits) {
            weight += fruit.getWeight();
        }
        return weight;
    }

    public void printBox() {
        for (T item : fruits) {
            System.out.println(item);
        }
    }

    public boolean sravnenie(Box<?> otherBox) {
        return Math.abs(this.getWeight() - otherBox.getWeight()) < 0.0001;
    }

    public void peresipka(Box<T> box) {
        if (!this.equals(box)) {
            if (box.hasLemon) {
                for (int i = 0; i < fruits.size(); i++) {
                    if (fruits.get(i).getClass().equals(Lemon.class)) {
                        box.fruits.add(fruits.get(i));
                        fruits.remove(i);
                        i--;
                    }
                }
            } else {
                for (int i = 0; i < fruits.size(); i++) {
                    if (!fruits.get(i).getClass().equals(Lemon.class)) {
                        box.fruits.add(fruits.get(i));
                        fruits.remove(i);
                        i--;
                    }
                }
            }
        }
    }
}