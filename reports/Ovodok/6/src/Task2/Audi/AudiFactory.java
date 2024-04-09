package Task2.Audi;

import Task2.Interfaces.CarAndRemoteControlFactory;
import Task2.Interfaces.Car;
import Task2.Interfaces.RemoteControl;

public class AudiFactory implements CarAndRemoteControlFactory {

    @Override
    public Car getCar() {
        return new AudiCar();
    }

    @Override
    public RemoteControl getController() {
        return new AudiRemoteControl();
    }
}
