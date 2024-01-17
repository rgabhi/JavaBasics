package introtosemaphores;

import java.util.Queue;
import java.util.concurrent.Semaphore;

public class Producer implements Runnable {
    String name;
    int maxSize;
    Queue<Object> shirts;
//    Lock lock;
    Semaphore p;
    Semaphore c;


    public  Producer(String name, Queue<Object> shirts, int maxSize, Semaphore p, Semaphore c){
        this.name = name;
        this.shirts = shirts;
        this.maxSize = maxSize;
//        this.lock = lock;
        this.p = p;
        this.c = c;
    }


    @Override
    public void run() {
        while(true) {
//            lock.lock();
            try {
                //need to add try-catch since acquire can throw exceptions
                p.acquire();
                if(shirts.size() < maxSize){
                    shirts.add(new Object());
                    System.out.println("Producer " + name  + " produced shirt: " + shirts.size());
                }
                c.release();
//            lock.unlock();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }
}
