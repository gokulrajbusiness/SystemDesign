package Concurrency.OddEven;

public class MainOddEven {

    public static void main(String... args)
    {
        OddEvenWorker worker = new OddEvenWorker(7);
        Thread  thread = new Thread(()->{

                try {
                    worker.printOdd();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }


        });

        Thread  thread3 = new Thread(()->{


                try {
                    worker.printEven();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }


        });


        Thread  thread2 = new Thread(()->{


                try {
                    worker.printZero();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

        });



        thread.start();
        thread2.start();
        thread3.start();



    }
}
