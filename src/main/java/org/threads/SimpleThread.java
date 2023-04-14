package org.threads;

public class SimpleThread implements Runnable {

    public static void main(String[] args) {

        SimpleThread st = new SimpleThread();
        Thread t = new Thread(st);
        t.start();
        System.out.println("running outside of thread");

    }

    @Override
    public void run() {
        System.out.println("running inside thread");
    }
}
