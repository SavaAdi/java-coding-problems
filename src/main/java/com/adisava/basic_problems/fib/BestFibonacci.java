package com.adisava.basic_problems.fib;

import java.util.stream.IntStream;

public class BestFibonacci {

    private int last = 0, next = 1; // fib(0), fib(1)
    public IntStream stream() {
        return IntStream.generate(() -> {
            int oldLast = last;
            last = next;
            next = oldLast + next;
            return oldLast;
        });
    }
    public static void main(String[] args) {
        var fib5 = new BestFibonacci();
        fib5.stream().limit(41).forEachOrdered(System.out::println);
    }
}
