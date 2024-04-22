abstract class Car {
    String brand;
    abstract void honk();
}

class Ford extends Car {
    Ford() {
        this.brand = "Ford";
    }

    @Override
    public void honk() {
        System.out.println(this.brand + " is honking at ya!");
    }
}

class Toyota extends Car {
    Toyota() {
        this.brand = "Toyota";
    }
    @Override
    public void honk() {
        System.out.println(brand + " ain't honking at you. Only staring.");
    }
}

interface RemoteControl {
    void activateSignaling();
    void manipulateDoors();
    void startEngine();
}

class FordRemote implements RemoteControl {
    @Override
    public void activateSignaling() {
        System.out.println("Ford-Ford signal activated!");
    }

    @Override
    public void manipulateDoors() {
        System.out.println("Your Ford door's configuration has been changed!");
    }

    @Override
    public void startEngine() {
        System.out.println("Ford says: vroom-vroom");
    }
}

class ToyotaRemote implements RemoteControl {
    @Override
    public void activateSignaling() {
        System.out.println("Toyota has activated signaling for you");
    }

    @Override
    public void manipulateDoors() {
        System.out.println("Toyota has changed door status.");
    }

    @Override
    public void startEngine() {
        System.out.println("Toyota is ready to roll.");
    }
}

interface CarFactory {
    Car createCar();
    RemoteControl createRemoteControl();
}

class FordFactory implements CarFactory {
    @Override
    public Car createCar() {
        return new Ford();
    }

    @Override
    public RemoteControl createRemoteControl() {
        return new FordRemote();
    }
}

class ToyotaFactory implements CarFactory {
    @Override
    public Car createCar() {
        return new Toyota();
    }

    @Override
    public RemoteControl createRemoteControl() {
        return new ToyotaRemote();
    }
}

class Client {
    private final Car car;
    private final RemoteControl remote;

    public Client(CarFactory carFactory) {
        car = carFactory.createCar();
        remote = carFactory.createRemoteControl();
    }

    public void showOff() {
        car.honk();
        remote.activateSignaling();
        remote.manipulateDoors();
        remote.startEngine();
    }
}

public class Task2 {
    public static void main(String[] args) {
        Client fordClient;
        CarFactory fordFactory;

        fordFactory = new FordFactory();
        fordClient = new Client(fordFactory);

        fordClient.showOff();

        System.out.println("-----------------------------");

        Client toyotaClient;
        CarFactory toyotaFactory;

        toyotaFactory = new ToyotaFactory();
        toyotaClient = new Client(toyotaFactory);

        toyotaClient.showOff();
    }
}
