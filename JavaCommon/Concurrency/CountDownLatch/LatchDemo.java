package Concurrency.CountDownLatch;

import java.util.concurrent.CountDownLatch;

public class LatchDemo {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(3);

        for (int i = 1; i <= 3; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + " finished.");
                latch.countDown();
            }).start();
        }

        latch.await();
        System.out.println("All threads completed.");
    }
}