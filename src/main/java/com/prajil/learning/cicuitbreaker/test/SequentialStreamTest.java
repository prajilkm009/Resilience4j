package com.prajil.learning.cicuitbreaker.test;

import java.util.Arrays;

public class SequentialStreamTest {

    public static void main (String[] args) {
        System.out.println("This is a placeholder for SequentialStreamTest.");


        long[] longArray = new long[20000];
        for(int i=0; i < longArray.length; i++) {
            longArray[i] = i+1;
        }

        long startTime = System.currentTimeMillis();
        long serialsum = Arrays.stream(longArray).map(SequentialStreamTest::factorial).sum();
        System.out.println("Seriel Sum"+serialsum);
        long endTime = System.currentTimeMillis();
        System.out.println("Time taken for serial processing: " + (endTime - startTime) + " milliseconds");
        startTime = System.currentTimeMillis();
        long parallelSum = Arrays.stream(longArray).parallel().map(SequentialStreamTest::factorial).sum();
        System.out.println("Parallel Sum"+parallelSum);
        endTime = System.currentTimeMillis();
        System.out.println("Time taken for parallel processing: " + (endTime - startTime) + " milliseconds");
    }

    private static long factorial(long longArray) {
        long result = 1;
        for (long i = 1; i <= longArray; i++) {
            result *= i;
        }
        return result;
    }

}
