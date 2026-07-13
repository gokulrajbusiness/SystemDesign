package Concurrency.CountDownLatch;

import java.util.concurrent.CountDownLatch;

public class WorkerCDL {


    CountDownLatch startLatch = new CountDownLatch(1);
    CountDownLatch endLatch = new CountDownLatch(5);

    public void cdlEx() {
        try{

           // startLatch.await();
            System.out.println("CDL");
            endLatch.countDown();
            System.out.println(endLatch.getCount());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
