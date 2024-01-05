package executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Client {
    public static void main(String[] args){
//        ExecutorService executorService = Executors.newCachedThreadPool();
        //Recommended to used fixed threadpool so that you can control number of threads.
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for(int i = 1; i <= 100; i++) {
            PrintNumber printNumber = new PrintNumber(i);
            executorService.execute(printNumber);
        }
    }

}
