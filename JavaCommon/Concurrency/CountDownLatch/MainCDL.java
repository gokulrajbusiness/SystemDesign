package Concurrency.CountDownLatch;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainCDL {


    public static void main (String... args)
    {

        try( ExecutorService s = Executors.newFixedThreadPool(5))
        {

            s.execute(()-> {
                WorkerCDL w = new WorkerCDL();
                w.cdlEx();

            });



        }







    }

}
