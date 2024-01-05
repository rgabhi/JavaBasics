package numberprinter;

public class Client {
    public static void main(String[] args){
        for(int i = 1; i <= 100; i++) {
            PrintNumber printNumber = new PrintNumber(i);
//            printNumber.run();
            Thread t = new Thread(printNumber);
            t.start();
        }

    }

}
