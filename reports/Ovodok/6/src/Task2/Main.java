package Task2;

import Task2.Audi.AudiFactory;
import Task2.Interfaces.Car;
import Task2.Interfaces.CarAndRemoteControlFactory;
import Task2.Interfaces.RemoteControl;
import Task2.Mersedes.MersedesFactory;

public class Main {
    public static void main(String[] args) {
        CarAndRemoteControlFactory carAndRemoteControl = new MersedesFactory();

        Car car =  carAndRemoteControl.getCar();
        RemoteControl remoteControl = carAndRemoteControl.getController();

        car.startEngine();
        car.drive();
        car.stopEngine();

        remoteControl.unlockDoors();
        remoteControl.startEngine();
        remoteControl.activateAlarm();
        remoteControl.lockDoors();
        System.out.println("----------------------------------------------");

        carAndRemoteControl = new AudiFactory();
        car =  carAndRemoteControl.getCar();
        remoteControl = carAndRemoteControl.getController();

        car.startEngine();
        car.drive();
        car.stopEngine();

        remoteControl.unlockDoors();
        remoteControl.startEngine();
        remoteControl.activateAlarm();
        remoteControl.lockDoors();

    }
}