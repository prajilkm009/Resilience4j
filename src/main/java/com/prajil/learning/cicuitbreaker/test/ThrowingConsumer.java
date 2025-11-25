package com.prajil.learning.cicuitbreaker.test;

@FunctionalInterface
public interface ThrowingConsumer <T,E extends Exception> {
    void accept(T t) throws E;
}
