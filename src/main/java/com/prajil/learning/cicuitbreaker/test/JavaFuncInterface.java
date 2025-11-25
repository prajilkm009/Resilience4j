package com.prajil.learning.cicuitbreaker.test;

import java.time.LocalTime;
import java.util.Collections;
import java.util.function.*;

public class JavaFuncInterface {

    public static void main(String[] args) {
        Function<String,Integer> func = s -> s.length();
        System.out.println("Length of 'Hello World' is: " + func.apply("Hello World"));

        Consumer<String> consumer = s -> System.out.println("Consumed value: " + s);
        consumer.accept("Test Value");

        Supplier<LocalTime> supplier = () -> LocalTime.now();
        System.out.println("Random value from Supplier: " + supplier.get());

        Predicate<Integer> predicate = i -> i > 10;
        System.out.println("Is 15 greater than 10? " + predicate.test(15));

        BiFunction<Integer, Integer, Integer> biFunction = (a, b) -> a + b;
        System.out.println("Sum of 5 and 10 is: " + biFunction.apply(5, 10));



        BiConsumer<String, String> biConsumer = (s1, s2) -> System.out.println("Concatenated String: " + s1 + s2);


    }
}
