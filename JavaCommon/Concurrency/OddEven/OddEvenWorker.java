package Concurrency.OddEven;

import java.util.concurrent.Semaphore;

public class OddEvenWorker {

    int number=1;
    boolean odd = true;

    Semaphore oddSemaphore = new Semaphore(0);
    Semaphore evenSemaphore = new Semaphore(0);
    Semaphore zeroSemaphore = new Semaphore(1);


    OddEvenWorker(int number)
    {

        this.number = number;
    }

    public void printOdd() throws InterruptedException {

        for(int i=1;i<=number;i=i+2) {
            oddSemaphore.acquire(1);
            System.out.println(i);
            zeroSemaphore.release(1);
        }



    }

    public void printEven() throws InterruptedException {
        for(int i=2;i<=number;i=i+2){
            evenSemaphore.acquire(1);
            System.out.println(i);
            zeroSemaphore.release(1);

        }
    }

    public void printZero() throws InterruptedException {
        for(int i=0;i<=number;i++)
        {
            zeroSemaphore.acquire(1);
            System.out.println(0);
            if(odd) {
                oddSemaphore.release(1);
            }
            else{
                evenSemaphore.release(1);
            }
            odd = !odd;

        }
    }
}
