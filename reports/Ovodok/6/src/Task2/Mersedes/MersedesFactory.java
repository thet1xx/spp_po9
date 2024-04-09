package Task2.Mersedes;

import Task2.Interfaces.CarAndRemoteControlFactory;
import Task2.Interfaces.Car;
import Task2.Interfaces.RemoteControl;

public class MersedesFactory implements CarAndRemoteControlFactory {
    @Override
    public Car getCar() {
        return new MersedesCar();
    }

    @Override
    public RemoteControl getController() {
        return new MersedesRemoteControl();
    }
}
