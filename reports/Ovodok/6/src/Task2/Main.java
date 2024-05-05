package Task2_2;


import Task2_2.Cars.AudiCar;
import Task2_2.Cars.MersedesCar;
import Task2_2.RemoteControl.RemoteControll;
import Task2_2.RemoteControl.RemoteControllBasic;
import Task2_2.RemoteControl.RemoteControllProMax;

public class Main {

    public static void main(String[] args) {

        RemoteControll remoteControllBasic = new RemoteControllBasic(new MersedesCar());
        RemoteControll remoteControllProMax = new RemoteControllProMax(new AudiCar());

        remoteControllBasic.unlockDoors();
        remoteControllBasic.startEngine();
        remoteControllBasic.activateAlarm();
        remoteControllBasic.stopEngine();
        remoteControllBasic.unlockDoors();

        System.out.println("-------------------------------------");

        remoteControllProMax.unlockDoors();
        remoteControllProMax.startEngine();
        remoteControllProMax.activateAlarm();
        remoteControllProMax.stopEngine();
        remoteControllProMax.unlockDoors();

    }



}
