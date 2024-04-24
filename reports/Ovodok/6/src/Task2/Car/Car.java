package Task2_1.Car;

import Task2_1.RemoteControl.RemoteControlInterface;

public abstract class Car {
    protected RemoteControlInterface remoteControl;

    public Car(RemoteControlInterface remoteControl) {
        this.remoteControl = remoteControl;
    }

    public abstract void start();
    public abstract void stop();
}
