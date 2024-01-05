package introtothreads;

import introtothreads.HelloWorldThread;

public class Main {
    public static void main(String[] args) {
//        System.out.println("Hello world!");
        HelloWorldThread helloWorldThread = new HelloWorldThread();
        Thread t1 = new Thread(helloWorldThread);
        Thread t2 = new Thread(helloWorldThread);
        t1.start();
        t2.start();
    }
}