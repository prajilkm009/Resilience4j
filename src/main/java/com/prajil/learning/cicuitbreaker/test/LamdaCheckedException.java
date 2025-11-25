package com.prajil.learning.cicuitbreaker.test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class LamdaCheckedException {

    public static void main(String[] args )  throws Exception {

        List<Integer> integers = Arrays.asList(3, 9, 7, 0, 10, 20);
        integers.forEach(throwingConsumerWrapper(i -> writeToFile(i)));

    }

    static void writeToFile(int i) throws Exception {
        throw new Exception("Checked Exception");
    }

    static <T> Consumer<T> throwingConsumerWrapper(
            ThrowingConsumer<T, Exception> throwingConsumer) {

        return i -> {
            try {
                throwingConsumer.accept(i);
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        };
    }

}





