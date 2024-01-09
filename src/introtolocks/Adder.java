package introtolocks;

import java.util.concurrent.Callable;

public class Adder implements Runnable{

    Count count;

    Adder(Count count){
        this.count = count;
    }


    @Override
    public void run() {
        for(int i= 1; i <= 1000; i++) {
            count.value += 1;
        }
    }
}
