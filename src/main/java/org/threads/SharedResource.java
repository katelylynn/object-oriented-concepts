package org.threads;

public class SharedResource {

    synchronized void print(String id) {
        System.out.format("Thread %s called print!\n", id);
    }

}
