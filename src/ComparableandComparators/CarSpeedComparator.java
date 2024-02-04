package ComparableandComparators;

import java.util.Comparator;

public class CarSpeedComparator implements Comparator<Car> {
    @Override
    public int compare(Car c1, Car c2){
        return c1.getSpeed() - c2.getSpeed();
    }
}
