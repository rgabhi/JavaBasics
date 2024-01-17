package introtosemaphores;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Semaphore;

public class Client {
    public static void main(String[] args) {
        int maxSize = 3;
        Queue<Object> shirts = new ConcurrentLinkedQueue<>();
//        Lock lock = new ReentrantLock();
//        as lock would only allow one thread into the critical section, but we need multiple,
//        hence, using semaphores
        Semaphore p = new Semaphore(3);
        Semaphore c = new Semaphore(0);
        Producer p1 = new Producer("P1", shirts, maxSize, p, c);
        Producer p2 = new Producer("P2", shirts, maxSize, p, c);
        Producer p3 = new Producer("P3", shirts, maxSize, p, c);

        Consumer c1 = new Consumer("C1", shirts, p, c);
        Consumer c2 = new Consumer("C2", shirts, p, c);
        Consumer c3 = new Consumer("C3", shirts, p, c);

        Thread t1 = new Thread(p1);
        Thread t2 = new Thread(p2);
        Thread t3 = new Thread(p3);
        Thread t4 = new Thread(c1);
        Thread t5 = new Thread(c2);
        Thread t6 = new Thread(c3);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();

    }
}
