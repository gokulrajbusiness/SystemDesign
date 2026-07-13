package Concurrency.ProducerConsumerReentrantLock;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Condition;

class WorkerRE {
    private final int limit;
    private final Queue<Integer> queue = new LinkedList<>();

    // One explicit lock
    private final Lock lock = new ReentrantLock();

    // Two separate "gates" or communication channels
    private final Condition notFull = lock.newCondition();
    private final Condition notEmpty = lock.newCondition();

    WorkerRE(int limit) {
        this.limit = limit;
    }

    public void produce(int i) throws InterruptedException {
        lock.lock(); // Acquire the lock
        try {
            while (queue.size() == limit) {
                notFull.await(); // Wait on the Producer gate
            }
            queue.add(i);

            notEmpty.signal(); // "Open the other gate" -> Wake up a Consumer!
        } finally {
            lock.unlock(); // Always unlock in a finally block
        }
    }

    public int consume() throws InterruptedException {
        lock.lock(); // Acquire the lock
        try {
            while (queue.isEmpty()) {
                notEmpty.await(); // Wait on the Consumer gate
            }
            int value = queue.poll();

            notFull.signal(); // "Open the other gate" -> Wake up a Producer!
            return value;
        } finally {
            lock.unlock();
        }
    }
}