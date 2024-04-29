package Task2_2.RemoteControl;

import Task2_2.Cars.Car;

public abstract class RemoteControll {
    protected Car car;
    public RemoteControll(Car car) {
        this.car = car;
    }
    public abstract void activateAlarm();
    public abstract void lockDoors();
    public abstract void unlockDoors();
    public abstract void startEngine();
    public abstract void stopEngine();
}
