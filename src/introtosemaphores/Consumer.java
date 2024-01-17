package introtosemaphores;

import java.util.Queue;
import java.util.concurrent.Semaphore;

public class Consumer implements Runnable{
    String name;
    Queue<Object> shirts;
//    Lock lock;
    Semaphore p;
    Semaphore c;

    public Consumer(String name, Queue<Object> shirts, Semaphore p, Semaphore c){
        this.name = name;
        this.shirts = shirts;
//        this.lock = lock;
        this.p = p;
        this.c = c;
    }

    @Override
    public void run() {
        while(true){
//            lock.lock();
            try {
                c.acquire();
                if(!shirts.isEmpty()){
                    shirts.remove();
                    System.out.println("Consumer " + name + " consumed shirt: " + shirts.size());
                }
                p.release();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
//            lock.unlock();
        }
    }
}
