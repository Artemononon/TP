package org.example;
import java.util.Arrays;
public class Main {
    static final int SIZE =60000000;
    static final int HALF = SIZE / 2;
    static int THREADS_COUNT = 7;

    public static void main(String[] args) {
        float[] arr = new float[SIZE];
        Arrays.fill(arr, 1.0f);

        System.out.println("Работа первого метода:");
        long startTime = System.currentTimeMillis();
        Formula(arr);
        long endTime = System.currentTimeMillis();
        Print(arr);
        System.out.println("\nВремя выполнения первого метода: " + (endTime - startTime) + " мс");

        arr = new float[SIZE];
        Arrays.fill(arr, 1.0f);
        System.out.println("\nРабота второго метода:");
        startTime = System.currentTimeMillis();
        Vich(arr);
        endTime = System.currentTimeMillis();
        Print(arr);
        System.out.println("\nВремя выполнения второго метода: " + (endTime - startTime) + " мс");
        while (SIZE % THREADS_COUNT != 0) {
            THREADS_COUNT++;
        }
        int threads = THREADS_COUNT;
        if (SIZE % threads == 0 && threads >= THREADS_COUNT) {
            arr = new float[SIZE];
            Arrays.fill(arr, 1.0f);
            System.out.println("\nРабота метода с " + threads + " потоками:");
            startTime = System.currentTimeMillis();
            Vich2(arr, threads);
            endTime = System.currentTimeMillis();
            Print(arr);
            System.out.println("\nВремя выполнения метода с " + threads + " потоками: " + (endTime - startTime) + " мс");
        }
    }


    private static void Formula(float[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
    }

    public static void Vich(float[] array) {
        float[] firstHalf = new float[HALF];
        float[] secondHalf = new float[HALF];

        System.arraycopy(array, 0, firstHalf, 0, HALF);
        System.arraycopy(array, HALF, secondHalf, 0, HALF);

        Thread threadOne = new Thread(() -> {
            for (int i = 0; i < firstHalf.length; i++) {
                firstHalf[i] = (float) (firstHalf[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
            System.arraycopy(firstHalf, 0, array, 0, firstHalf.length);
            System.out.println("Результат первого потока: " + firstHalf.length);

        });
        threadOne.start();

        Thread threadTwo = new Thread(() -> {
            for (int i = 0; i < secondHalf.length; i++) {
                secondHalf[i] = (float) (secondHalf[i] * Math.sin(0.2f + (HALF + i) / 5) * Math.cos(0.2f + (HALF + i) / 5) * Math.cos(0.4f + (HALF + i) / 2));
            }
            System.arraycopy(secondHalf, 0, array, HALF, secondHalf.length);
            System.out.println("Результат второго потока: " + secondHalf.length);
        });
        threadTwo.start();

        try {
            threadOne.join();
            threadTwo.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void Vich2(float[] arr, int Potok_Kolvo) {

        int PotokSize = arr.length / Potok_Kolvo;
        Thread[] threads = new Thread[Potok_Kolvo];

        for (int i = 0; i < Potok_Kolvo; i++) {
            final int threadIndex = i;
            int startIndex = i * PotokSize;
            int endIndex = (i == Potok_Kolvo - 1) ? arr.length : (i + 1) * PotokSize;
            threads[i] = new Thread(() -> {
                Formula_V_Potoke(arr, startIndex, endIndex);
                float[] result = Arrays.copyOfRange(arr, startIndex, endIndex);
                System.out.println("Результат потока " + (threadIndex + 1) + ": " + result.length);
            });
            threads[i].start();
        }

        for (int i = 0; i < Potok_Kolvo; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static void Formula_V_Potoke(float[] arr, int startIndex, int endIndex) {
        for (int i = startIndex; i < endIndex; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
    }

    private static void Print(float[] arr) {
      System.out.println("Первая ячейка: " + arr[0]);
        System.out.println("Последняя ячейка: " + arr[arr.length - 1] + "\n");
        //System.out.println(Arrays.toString(arr));
    }
}