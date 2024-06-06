package Day6;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Day6 {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        //Using lambda Expression with streams to filter and print even number
        numbers.stream().filter(num -> num % 2 == 0).sorted().forEach(num -> System.out.println(num));

        System.out.println("Threading");

        ExecutorService executor = Executors.newFixedThreadPool(3);

        executor.submit(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("Task 1 - Executing on Thread" + Thread.currentThread().getName());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        executor.submit(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("Task 2 - Executing on thread: " + Thread.currentThread().getName());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        executor.submit(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("Task 3 - Executing on thread: " + Thread.currentThread().getName());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        // Shutting down the executor service
        executor.shutdown();
    }
}
