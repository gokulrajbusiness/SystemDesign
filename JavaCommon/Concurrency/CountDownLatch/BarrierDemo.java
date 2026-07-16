package Concurrency.CountDownLatch;

import java.util.concurrent.CyclicBarrier;

public class BarrierDemo {
    public static void main(String[] args) {
        CyclicBarrier barrier = new CyclicBarrier(3,
                () -> System.out.println("All threads reached the barrier."));

        Runnable task = () -> {
            try {
                System.out.println(Thread.currentThread().getName() + " is working.");
                Thread.sleep(1000);

                System.out.println(Thread.currentThread().getName() + " waiting.");
                barrier.await();

                System.out.println(Thread.currentThread().getName() + " continues.");
            } catch (Exception e) {
                e.printStackTrace();
            }
        };

        for (int i = 0; i < 5; i++) {
            new Thread(task).start();
        }
    }
}