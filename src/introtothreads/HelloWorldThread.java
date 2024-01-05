package introtothreads;

public class HelloWorldThread implements Runnable{
    @Override
    public void run(){
        System.out.println("Hello World from " + Thread.currentThread().getName());
    }

}
