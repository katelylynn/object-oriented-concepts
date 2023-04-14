package org.threads;

public class Counter {

    private int c = 0;

    public void increment() {
        c++;
        System.out.println(c);
    }

    public void decrement() {
        c--;
    }

    public int value() {
        return c;
    }

}
