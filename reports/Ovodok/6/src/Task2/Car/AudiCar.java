package Task2_1.Car;

import Task2_1.RemoteControl.RemoteControl;

public class AudiCar extends Car {


    public AudiCar(RemoteControl remoteControl) {
        super(remoteControl);
    }

    @Override
    public void start() {
        System.out.println("Запуск автомобиля Audi");
        remoteControl.startEngine();
        remoteControl.unlockDoors();
        remoteControl.activateAlarm();
    }

    @Override
    public void stop() {
        System.out.println("Остановка автомобиля Audi");
        remoteControl.lockDoors();
    }

}
