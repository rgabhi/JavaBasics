package executors;

public class PrintNumber implements Runnable{
    int number;
    PrintNumber(int number){
        this.number = number;
    }


    @Override
    public void run() {
        System.out.println("Thread : " + Thread.currentThread().getName() + ", Number : " + number);
    }
}
