package Task2_1;

import Task2_1.Car.AudiCar;
import Task2_1.Car.Car;
import Task2_1.Car.MersedesCar;
import Task2_1.RemoteControl.RemoteControl;
import Task2_1.RemoteControl.RemoteControlProMax;

public class Main {

    public static void main(String[] args) {
        Car audiCar = new AudiCar(new RemoteControl());
        Car mersedesCar = new MersedesCar(new RemoteControlProMax());

        audiCar.start();
        audiCar.stop();

        System.out.println("-------------------------------------");

        mersedesCar.start();
        mersedesCar.stop();

    }



}
