package ComparableandComparators;

import java.util.Comparator;

public class CarAvgComparator implements Comparator<Car> {
    @Override
    public int compare(Car c1, Car c2){
        return c1.getAvg() - c2.getAvg();
    }
}
