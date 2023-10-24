package org.example;

import java.util.Random;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        Box<Apple> appleBox1 = new Box<>(new Apple());
        Box<Apple> appleBox2 = new Box<>(new Apple(), new Apple(), new Apple());

        Box<Orange> orangeBox = new Box<>(new Orange());
        orangeBox.addFruits(2);

        Box<Fruit> fruitBox1 = new Box<>(new Lemon(), new Apple(), new Lemon());
        Box<Fruit> fruitBox2 = new Box<>(new Lemon(), new Orange(), new Lemon());

//        System.out.println("Вес первой коробки с яблоками: " + appleBox1.getWeight());
//        System.out.println("Вес второй коробки с яблоками: " + appleBox2.getWeight());
//        System.out.println("Вес коробки с апельсинами: " + orangeBox.getWeight());
//        System.out.println("Вес первой коробки с фруктами: " + fruitBox1.getWeight());
//        System.out.println("Вес второй коробки с фруктами: " + fruitBox2.getWeight());
//
//        System.out.println("\nКоробка с яблоками столько же весит, как и коробка с апельсинами? " + appleBox2.sravnenie(orangeBox));
//
        System.out.println("\nСодержимое коробки до пересыпания: ");
        fruitBox2.printBox();
        fruitBox1.peresipka(fruitBox2);
        System.out.println("\nСодержимое коробки после пересыпания: ");

        fruitBox2.printBox();

//        Integer[] array = {1, 2, 3};
//        swapElements(array);
//        System.out.println(Arrays.toString(array));
//
//        ArrayList<Integer> list = ArrayToList(array);
//        System.out.println(list);
    }

    public static <T> void swapElements(T[] array) {
        Random random = new Random();
        int index1 = random.nextInt(array.length);
        int index2 = random.nextInt(array.length);
        T temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    public static <T> ArrayList<T> ArrayToList(T[] array) {
        if (array == null) {
            return null;
        }
        ArrayList<T> list = new ArrayList<>();
        Collections.addAll(list, array);
        return list;
    }
}