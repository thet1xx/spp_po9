package Task2_2.RemoteControl;


import Task2_2.Cars.Car;

public class RemoteControllBasic extends RemoteControll {
    public RemoteControllBasic(Car car) {
        super(car);
    }

    @Override
    public void activateAlarm() {

        System.out.println("Сигнализация активирована со звуком виу-виу-виу");
    }

    @Override
    public void lockDoors() {

        System.out.println("Закрытие дверей с расстояния 10м");
    }

    @Override
    public void unlockDoors() {

        System.out.println("Открытие дверей с расстояния 10м");
    }

    @Override
    public void startEngine() {
        car.start();
        System.out.println("Запуск двигателя с расстояния 10м");
    }

    @Override
    public void stopEngine() {
        car.stop();
        System.out.println("Остановка двигателя с расстояния 10м");
    }

}
