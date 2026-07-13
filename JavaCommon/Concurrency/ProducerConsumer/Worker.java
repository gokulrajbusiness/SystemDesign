package Concurrency.ProducerConsumer;

import java.util.LinkedList;
import java.util.Queue;

class Worker {

    private final int limit;
    Queue<Integer> queue = new LinkedList<>();

    Worker(int limit) {
        this.limit = limit;
    }

    public void produce(int i) throws InterruptedException {
        synchronized (queue) {
            if (queue.size() == limit) {
                queue.wait();
            }
            queue.add(i);
            queue.notify();
        }
    }

    public int consume() throws InterruptedException {
        synchronized (queue) {
            if (queue.isEmpty())
                queue.wait();
            int value = queue.poll();
            queue.notify();
            return value;
        }
    }
}