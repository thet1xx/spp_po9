abstract class Transport{
    private String name;
    private String type;
    private double speed;
    private double costPerHour;

    public Transport(String name, String type, double speed, double costPerHour){
        this.name = name;
        this.type = type;
        this.speed = speed;
        this.costPerHour = costPerHour;
    }

    public String getType(){
        return type;
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

    public void information(){
        System.out.println("Вид транспорта: " + name + "\nВид перевозки: " + type);
    }
}

class Car extends Transport{
    private int passengerCapacity;
    public Car(String name, String type, int speed, int costPerHour, int passengerCapacity){
        super(name, type,speed, costPerHour);
        this.passengerCapacity = passengerCapacity;
    }
    @Override
    public void information(){
        super.information();
        System.out.println("Кол-во пассажиров: " + passengerCapacity);
    }
}

class Bicycle extends Transport{
    public Bicycle(String name, String type, int speed, int costPerHour){
        super(name, type, speed, costPerHour);
    }
}

class Cart extends Transport{
    private int horsePower;
    public Cart(String name, String type, int speed, int costPerHour, int horsePower){
        super(name, type,speed, costPerHour);
        this.horsePower = horsePower;
    }

    @Override
    public void information(){
        super.information();
        System.out.println("Лошадей: " + horsePower);
    }

}

public class task2 {
    public static void main(String[] args){
        Transport[] transports = new Transport[3];

        transports[0] = new Car("Автомобиль", "Грузовой", 120, 30, 4);
        transports[1] = new Bicycle("Велосипед", "Пассажирский", 25, 5);
        transports[2] = new Cart("Повозка", "Грузовой", 50, 10, 2);

        for(Transport transport : transports){
            transport.information();
            if(transport.getType().equals("Пассажирский")){
                double passengerTime = transport.calculatePassengerTime(100);
                double passengerCost = transport.calculatePassengerCost(100);
                System.out.println("Время перевозки груза: " + passengerTime + "\nСтоимость: " + passengerCost + "\n");
            }else {
                double cargoTime = transport.calculateCargoTime(50);
                double cargoCost = transport.calculateCargoCost(50);
                System.out.println("Время перевозки груза: " + cargoTime + "\nСтоимость: " + cargoCost + "\n");
            }

        }
}
