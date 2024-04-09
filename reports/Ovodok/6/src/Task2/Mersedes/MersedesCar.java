package Task2.Mersedes;

import Task2.Interfaces.Car;

public class MersedesCar implements Car {
    @Override
    public void startEngine() {
        System.out.println("(MERSEDES)Двигатель запускается 2 сек.");
    }

    @Override
    public void stopEngine() {
        System.out.println("(MERSEDES)Двигатель останавливается со звуком УХГРУХРРУРХ");
    }

    @Override
    public void drive() {
        System.out.println("(MERSEDES)Едет с максимальной скоростью 150 км/ч");
    }
}