package Task2.Audi;

import Task2.Interfaces.RemoteControl;

public class AudiRemoteControl implements RemoteControl {
    @Override
    public void activateAlarm() {
        System.out.println("(AUDI)Сигнализация активирована со звуком виу-виу-виу");
    }

    @Override
    public void lockDoors() {
        System.out.println("(AUDI)Открытие дверей с расстояния 10м");
    }

    @Override
    public void unlockDoors() {
        System.out.println("(AUDI)Закрытие дверей с расстояния 10м");
    }

    @Override
    public void startEngine() {
        System.out.println("(AUDI)Запуск двигателя с расстояния 10м");
    }

}
