package Task2_1.RemoteControl;

public class RemoteControl implements RemoteControlInterface {
    @Override
    public void activateAlarm() {
        System.out.println("Сигнализация активирована со звуком виу-виу-виу");
    }

    @Override
    public void lockDoors() {
        System.out.println("Открытие дверей с расстояния 10м");
    }

    @Override
    public void unlockDoors() {
        System.out.println("Закрытие дверей с расстояния 10м");
    }

    @Override
    public void startEngine() {
        System.out.println("Запуск двигателя с расстояния 10м");
    }

}
