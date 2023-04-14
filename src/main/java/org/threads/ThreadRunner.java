package org.threads;

public class ThreadRunner {

    int threadcount = 1000;
    int samplecount = 10;

    public void RunCounter() {
        Counter counter = new Counter();
        Thread[] pool = new Thread[threadcount];
        for (int i = 0; i < threadcount; i+=2) {
            pool[i] = new Thread(() -> counter.increment());
            pool[i+1] = new Thread(() -> counter.increment());
            pool[i].start();
            pool[i+1].start();
        }
        for (int i = 0; i < threadcount; i++) {
            try {
                pool[i].join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.format("No-sync sample: %d\n", counter.value());

    }

    public void RunSyncCounter() {
        SynchronizedCounter synchronizedCounter = new SynchronizedCounter();
        Thread[] syncpool = new Thread[threadcount];
        for (int i = 0; i < threadcount; i+=2) {
            syncpool[i] = new Thread(() -> synchronizedCounter.increment());
            syncpool[i+1] = new Thread(() -> synchronizedCounter.increment());
            syncpool[i].start();
            syncpool[i+1].start();
        }
        for (int i = 0; i < threadcount; i++) {
            try {
                syncpool[i].join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.format("Sync sample: %d\n", synchronizedCounter.value());

    }

    public static void main(String[] args) throws InterruptedException {
        ThreadRunner threadRunner = new ThreadRunner();
        for (int i = 0; i < 100; i++) {
            threadRunner.RunCounter();
            threadRunner.RunSyncCounter();
        }
    }


}
