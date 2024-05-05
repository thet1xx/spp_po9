package Task2_2.Cars;

public class AudiCar implements Car {

    @Override
    public void start() {
        System.out.println("Запуск автомобиля audi");
    }

    @Override
    public void stop() {
        System.out.println("Остановка автомобиля audi");
    }
}