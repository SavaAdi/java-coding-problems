package com.adisava.basicproblems.fib;

import java.util.HashMap;
import java.util.Map;

/*
    The Fibonacci sequence is a sequence of numbers such that any number, except
    for the first and second, is the sum of the previous two:
    0, 1, 1, 2, 3, 5, 8, 13, 21...
    The value of the first Fibonacci number in the sequence is 0. The value of the
    fourth Fibonacci number is 2. It follows that to get the value of any Fibonacci number,
    n, in the sequence, one can use the formula
    fib(n) = fib(n - 1) + fib(n - 2)
 */
public class Fibonacci {

    // This method will cause a java.lang.StackOverflowError
    private static int fib1(int n) {
        return fib1(n - 1) + fib1(n - 2);
    }

    private static int fib2(int n) {
        if (n < 2) { return n; }
        return fib2(n - 1) + fib2(n - 2);
    }

    // Map.of() was introduced in Java 9 but returns
    // an immutable Map
    // This creates a map with 0->0 and 1->1
    // which represent our base cases
    static Map<Integer, Integer> memo = new HashMap<>(Map.of(0, 0, 1, 1));

    private static int fib3(int n) {

        if (!memo.containsKey(n)) {
        // memoization step
            memo.put(n, fib3(n - 1) + fib3(n - 2));
        }

        return memo.get(n);
    }

    private static int fib4(int n) {
        int last = 0, next = 1; // fib(0), fib(1)
        for (int i = 0; i < n; i++) {
            int oldLast = last;
            last = next;
            next = oldLast + next;
        }
        return last;
    }

    public static void main(String[] args) {
        // Don't run this!
//        System.out.println(fib1(5));

        System.out.println(fib2(5));

        System.out.println(fib3(5));

        System.out.println(fib4(5));
    }
}
