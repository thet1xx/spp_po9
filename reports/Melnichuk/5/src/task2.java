class Transport{
    private String name;
    private double speed;
    private double costPerHour;

    public Transport(String name, double speed, double costPerHour){
        this.name = name;
        this.speed = speed;
        this.costPerHour = costPerHour;
    }

    public double calculatePassengerTime(double distance){
        return distance / speed;
    }

    public double calculateCargoTime(double distance){
        return distance / speed;
    }

    public double calculatePassengerCost(double distance){
        double time = calculatePassengerTime(distance);
        return time * costPerHour;
    }

    public double calculateCargoCost(double distance){
        double time = calculateCargoTime(distance);
        return time * costPerHour;
    }

    public void information(String type, double time, double cost){
        System.out.println("Вид транспорта: " + name + "\nВид перевозки:" + type + "\nВремя перевозки: " + time + "\nСтоимость: " + cost + "\n");
    }
}

class Car extends Transport{
    public Car(){
        super("Автомобиль", 60, 10);
    }
}

class Bicycle extends Transport{
    public Bicycle(){
        super("Велосипед", 20, 0);
    }
}

class Cart extends Transport{
    public Cart(){
        super("Повозка", 10, 5);
    }
}

public class task2 {
    public static void main(String[] args){
        Car car = new Car();
        double carPassengerTime = car.calculatePassengerTime(100);
        double carPassengerCost = car.calculatePassengerCost(100);
        car.information("Пассажирский",carPassengerTime, carPassengerCost);

        Bicycle bicycle = new Bicycle();
        double bicycleCargoTime = bicycle.calculateCargoTime(50);
        double bicycleCargoCost = bicycle.calculateCargoCost(50);
        bicycle.information("Грузовой", bicycleCargoTime, bicycleCargoCost);

        Cart cart = new Cart();
        double cartPassengerTime = cart.calculatePassengerTime(80);
        double cartPassengerCost = cart.calculatePassengerCost(80);
        cart.information("Пассажирский", cartPassengerTime, cartPassengerCost);
    }
}
