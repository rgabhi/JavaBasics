package ComparableandComparators;

public class Car implements Comparable<Car>{
    private int speed;
    private int avg;
    private int price;

    public Car(int  speed, int avg, int price){
        this.speed = speed;
        this.avg = avg;
        this.price = price;
    }

    public int getAvg() {
        return avg;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setAvg(int avg) {
        this.avg = avg;
    }


    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }


    @Override
    public int compareTo(Car c){
        int speedComp =  (this.speed - c.speed);
        int avgComp = this.avg - c.avg;
        int priceComp = this.price - c.price;
        return speedComp != 0 ? speedComp : avgComp != 0 ? avgComp : priceComp;
    }

    @Override
    public String toString(){
        return "Speed : " + this.speed + ", Avg : " + this.avg + ", Price : " + this.price;
    }

}
