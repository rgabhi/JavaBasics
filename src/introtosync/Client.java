package introtosync;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Client {
    public static void main(String[] args) throws InterruptedException {
        Count count = new Count();
//        count.value = 0;
        Thread t1 = new Thread(new Adder(count));
        Thread t2 = new Thread(new Subtractor(count));
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(count.value);
    }
}
