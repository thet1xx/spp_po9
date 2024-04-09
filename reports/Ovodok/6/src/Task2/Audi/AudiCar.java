package Task2.Audi;

import Task2.Interfaces.Car;

public class AudiCar implements Car {
    @Override
    public void startEngine() {
        System.out.println("(AUDI)Двигатель запускается 3 сек.");
    }

    @Override
    public void stopEngine() {
        System.out.println("(AUDI)Двигатель останавливается со звуком арграгрхахр");
    }

    @Override
    public void drive() {
        System.out.println("(AUDI)Едет с максимальной скоростью 100 км/ч");
    }
}
