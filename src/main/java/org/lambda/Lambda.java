package org.lambda;

import java.util.ArrayList;
import java.util.Arrays;

public class Lambda {

    Integer[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

    int add(int a, int b) {
        return a+b;
    }

    int add(int a, int b, int c, int d) {
        return a+b+c+d;
    }

    int add(Integer[] args) {
        ArrayList<Integer> numbers = new ArrayList<Integer>(Arrays.asList(args));
        return numbers.stream().reduce(0, (acc, e) -> acc + e);
    }

    int add(int... args) {
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        for (int arg : args) {
            numbers.add((Integer) arg);
        }
        return numbers.stream().reduce(0, (acc, e) -> acc + e);
    }

}
