package org.example;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

public class Car implements Runnable {
    private static boolean winnerFound;
    private static final Car[] winners = new Car[3];
    private static final AtomicInteger position = new AtomicInteger(0);
    private CyclicBarrier cb;
    private CyclicBarrier cb1;
    private Race race;
    private int speed;
    private String name;


    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }

    public Car(Race race, int speed, CyclicBarrier cb, CyclicBarrier cb1, AtomicInteger position) {
        this.race = race;
        this.speed = speed;
        this.cb = cb;
        this.cb1 = cb1;
        this.name = "Участник #" + position.incrementAndGet();
    }

    @Override
    public void run() {
        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int) (Math.random() * 800));
            System.out.println(this.name + " готов");
            cb.await();

            for (int i = 0; i < race.getStages().size(); i++) {
                race.getStages().get(i).go(this);
                if (i == race.getStages().size() - 1)
                    checkWin(this);
            }
            cb1.await();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void checkWin(Car car) {
        if (!winnerFound) {
            int currentPosition = position.incrementAndGet();
            if (currentPosition <= 3) {
                winners[currentPosition - 1] = car;
                if (currentPosition == 3) {
                    winnerFound = true;
                }
            }
        }
    }

    public static void printWinners() {
        System.out.println("ПОБЕДИТЕЛИ");
        for (int i = 0; i < 3; i++) {
            System.out.println((i + 1) + " МЕСТО: " + winners[i].getName());
        }
    }
}