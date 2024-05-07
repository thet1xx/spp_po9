package Task2_2.Cars;


public class MersedesCar implements Car {

    @Override
    public void start() {
        System.out.println("Запуск автомобиля Mersedes");
    }

    @Override
    public void stop() {
        System.out.println("Остановка автомобиля Mersedes");
    }
}