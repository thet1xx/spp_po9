package Task2_1.Car;

import Task2_1.RemoteControl.RemoteControlInterface;

public class MersedesCar extends Car {
    public MersedesCar(RemoteControlInterface remoteControl) {
        super(remoteControl);
    }

    @Override
    public void start() {
        System.out.println("Запуск автомобиля Mersedes");
        remoteControl.startEngine();
        remoteControl.unlockDoors();
        remoteControl.activateAlarm();
    }

    @Override
    public void stop() {
        System.out.println("Остановка автомобиля Mersedes");
        remoteControl.lockDoors();
    }
}