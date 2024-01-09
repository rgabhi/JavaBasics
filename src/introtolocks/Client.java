package introtolocks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Client {
    public static void main(String[] args) throws InterruptedException {
        Count count = new Count();
        Lock lock = new ReentrantLock();
        count.value = 0;
        Thread t1 = new Thread(new Adder(count, lock));
        Thread t2 = new Thread(new Subtractor(count, lock));
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(count.value);
    }
}
