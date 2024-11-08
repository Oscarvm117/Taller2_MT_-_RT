package com.example;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Ejemplo {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(2, 3, 4, 5);

        List<Callable<Integer>> tasks = Arrays.asList(
            () -> {
                int number = numbers.get(0);
                return number * number;
            },
            () -> {
                int number = numbers.get(1);
                return number * number; 
            },
            () -> {
                int number = numbers.get(2);
                return number * number;
            },
            () -> {
                int number = numbers.get(3);
                return number * number; 
            }
        );

        ExecutorService executor = Executors.newFixedThreadPool(4);

        try {
            List<Future<Integer>> results = executor.invokeAll(tasks);
            int sumOfSquares = 0;
            for (Future<Integer> result : results) {
                sumOfSquares += result.get(); 
            }
            System.out.println("Suma de cuadrados: " + sumOfSquares);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } finally {
            executor.shutdown(); 
        }
    }
}
