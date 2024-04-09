package Task2.Mersedes;

import Task2.Interfaces.RemoteControl;

public class MersedesRemoteControl implements RemoteControl {
    @Override
    public void activateAlarm() {
        System.out.println("(MERSEDES)Сигнализация активирована со звуком воу-воу-воу");
    }

    @Override
    public void lockDoors() {
        System.out.println("(MERSEDES)Открытие дверей с расстояния 10м");
    }

    @Override
    public void unlockDoors() {
        System.out.println("(MERSEDES)Закрытие дверей с расстояния 10м");
    }

    @Override
    public void startEngine() {
        System.out.println("(MERSEDES)Запуск двигателя с расстояния 10м");
    }

}
