package Concurrency.ProducerConsumerReentrantLock;

import java.util.*;

//The Task: Implement a bounded queue where producers block when the queue is full, and consumers block when it's empty.
//What they look for: Can you implement this using standard wait()/notify() on a synchronized block?
// Can you optimize it using explicit Lock and multiple Condition variables (notFull, notEmpty)

public class MainREL {

    public static void main(String... args){

        WorkerRE worker =new WorkerRE(15);

        Thread  thread = new Thread(()->{

            for(int i=0;i<=50;i++) {
                try {
                    worker.produce(i);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

        });

        Thread  thread3 = new Thread(()->{

            for(int i=100;i<=150;i++) {
                try {
                    worker.produce(i);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

        });


        Thread  thread2 = new Thread(()->{

            for(int i=0;i<=50;i++) {
                try {
                    System.out.println( worker.consume());
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });


        thread.start();
        thread2.start();
        thread3.start();


    }
}