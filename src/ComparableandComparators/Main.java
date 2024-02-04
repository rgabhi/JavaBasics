package ComparableandComparators;

import java.util.*;

public class Main {
    public static void main(String[] args) {
//        System.out.println("Hello world!");
        Car c1 = new Car(200, 5, 25000000);
        Car c2 = new Car(110, 15, 1000000);
        Car c3 = new Car(150, 16, 2000000);
        Car c4 = new Car(200, 15, 2500000);
        //using comparable
//        PriorityQueue<Car> pq = new PriorityQueue<>();
        // using comparator
//        PriorityQueue<Car> pq = new PriorityQueue<>(new CarAvgComparator());
//        PriorityQueue<Car> pq = new PriorityQueue<>(new CarSpeedComparator());
//        Comparator<Car> priceComparator = (k1, k2) -> k1.getPrice() - k2.getPrice();
        PriorityQueue<Car> pq = new PriorityQueue<>((k1, k2) -> k2.getPrice() - k1.getPrice());
        pq.add(c1);pq.add(c2);pq.add(c3);pq.add(c4);
        while(!pq.isEmpty()){
           Car c = pq.peek();
           System.out.println(c);
           pq.remove();
        }

    }

}