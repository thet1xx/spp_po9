class PassengerCarrier {
    protected int travelTimeInMin;
    protected int costOfTravel;

    public PassengerCarrier(int travelTimeInSec, int costOfTravel) {
        this.travelTimeInMin = travelTimeInSec;
        this.costOfTravel = costOfTravel;
    }

    public void travel() {
        System.out.println("The carrier will reach its destination in "
                + travelTimeInMin
                + " minutes. Travel will cost you "
                + costOfTravel);
    }

    public void start() {
        System.out.println("Carrier departs...");
    }

    public void stop() {
        System.out.println("Carrier has reached its destination. " +
                "Thank you for using our carrier.");
    }
}

class Plane extends PassengerCarrierAbstract {
    String airline;
    public Plane (int travelTimeInSec, int costOfTravel, String airline) {
        super(travelTimeInSec, costOfTravel);
        this.airline = airline;
    }
    @Override
    public void travel() {
        System.out.println("The plane will fly to its destination in "
                + travelTimeInMin
                + " minutes. Travel will cost you "
                + costOfTravel);
    }

    public void fly() {
        System.out.println("You're flying by \"" + airline + "\" airline!");
    }
}

class Train extends PassengerCarrierAbstract {
    boolean isElectric;
    public Train (int travelTimeInSec, int costOfTravel, boolean isElectric) {
        super(travelTimeInSec, costOfTravel);
        this.isElectric = isElectric;
    }

    @Override
    public void travel() {
        System.out.println("The train will choo-choo to its destination in "
                + travelTimeInMin
                + " minutes. Travel will cost you "
                + costOfTravel);
    }

    public void showType () {
        if (isElectric) System.out.println("You're travelling by electric train.");
        else System.out.println("You're travelling by an old type of train.");
    }
}

class Car extends PassengerCarrierAbstract {
    String brand;

    public Car (int travelTimeInSec, int costOfTravel, String brand) {
        super(travelTimeInSec, costOfTravel);
        this.brand = brand;
    }

    @Override
    public void travel() {
        System.out.println("The car will drive to its destination in "
                + travelTimeInMin
                + " minutes. Travel will cost you "
                + costOfTravel);
    }

    public void showOffModel () {
        System.out.println("My car is of " + brand + " brand!");
    }
}

public class Task2 {
    public static void main(String[] args) {
        PassengerCarrierAbstract[] carriers = new PassengerCarrierAbstract[3];

        carriers[0] = new PlaneAbstract(3600, 500, "Belavia");
        carriers[1] = new TrainAbstract(7200, 200, true);
        carriers[2] = new CarAbstract(18000, 100, "Toyota Corolla");

        for (PassengerCarrierAbstract carrier : carriers) {
            carrier.start();
            carrier.travel();
            if (carrier instanceof PlaneAbstract) {
                ((PlaneAbstract) carrier).fly();
            } else if (carrier instanceof TrainAbstract) {
                ((TrainAbstract) carrier).showType();
            } else if (carrier instanceof CarAbstract) {
                ((CarAbstract) carrier).showOffModel();
            }
            carrier.stop();
            System.out.println();
        }
    }
}
