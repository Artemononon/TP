package org.example;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    static final int CARS = 6;
    public static final int TUNNEL_CONSTRAINT = 3;

    public static void main(String[] args) {
        Random random = new Random();
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");

        CyclicBarrier cb = new CyclicBarrier(CARS + 1);
        CyclicBarrier cb1 = new CyclicBarrier(CARS+1);

        Race race = new Race(new Road(60), new Tunnel(), new Road(40));
        Car[] cars = new Car[CARS];
        AtomicInteger position = new AtomicInteger(0);

        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(race, 20 * (random.nextInt(300) + 1), cb, cb1 , position);
        }

        for (int i = 0; i < cars.length; i++) {
            new Thread(cars[i]).start();
        }

        try {
            cb.await();
            System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            cb1.await();
            System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");
            Car.printWinners();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (BrokenBarrierException e) {
            throw new RuntimeException(e);
        }

    }
}