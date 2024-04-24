interface Car {
    void honk();
    void doors();
    void start();
}

class Ford implements Car {
    @Override
    public void honk() {
        System.out.println("Ford is honking at ya!");
    }

    @Override
    public void doors() {
        System.out.println("Your Ford door's configuration has been changed!");
    }

    @Override
    public void start() {
        System.out.println("Ford has started: vroom-vroom");
    }
}

class Toyota implements Car {
    @Override
    public void honk() {
        System.out.println("Toyota ain't honking at you. Only staring.");
    }

    @Override
    public void doors() {
        System.out.println("Toyota has changed door status.");
    }

    @Override
    public void start() {
        System.out.println("Toyota is ready to roll.");
    }
}

class CarRemote {
    private final Car car;

    CarRemote(Car car) {
        this.car = car;
    }

    public void activateSignaling() {
        car.honk();
    }

    public void manipulateDoors() {
        car.doors();
    }

    public void startEngine() {
        car.start();
    }
}


public class Task2 {
    public static void main(String[] args) {
        Car ford = new Ford();
        CarRemote fordRemote = new CarRemote(ford);

        System.out.println("Ford Client:");
        fordRemote.activateSignaling();
        fordRemote.manipulateDoors();
        fordRemote.startEngine();

        System.out.println("-----------------------------");

        Car toyota = new Toyota();
        CarRemote toyotaRemote = new CarRemote(toyota);

        System.out.println("Toyota Client:");
        toyotaRemote.activateSignaling();
        toyotaRemote.manipulateDoors();
        toyotaRemote.startEngine();
    }
}
