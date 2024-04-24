package Task2_1.RemoteControl;

import Task2_1.RemoteControl.RemoteControlInterface;

public class RemoteControlProMax implements RemoteControlInterface {
    @Override
    public void activateAlarm() {
        System.out.println("Сигнализация активирована со звуком воу-воу-воу");
    }

    @Override
    public void lockDoors() {
        System.out.println("Открытие дверей с расстояния 50м");
    }

    @Override
    public void unlockDoors() {
        System.out.println("Закрытие дверей с расстояния 50м");
    }

    @Override
    public void startEngine() {
        System.out.println("Запуск двигателя с расстояния 50м");
    }

}
