public class Lab4_3 {

    public static void main(String[] args) {
        Dispatcher dispatcher = new Dispatcher();
        Car car1 = new Car("Lada Granta", "A1234");
        Car car2 = new Car("Toyota Camry", "B5678");
        dispatcher.addCar(car1);
        dispatcher.addCar(car2);

        Driver driver1 = new Driver("Иван");
        Driver driver2 = new Driver("Петр");
        dispatcher.addDriver(driver1);
        dispatcher.addDriver(driver2);

        Trip trip= dispatcher.assignTrip("Владивосток");
        System.out.println(trip);
        dispatcher.removeDriver(driver2);
        driver1.markTripCompleted();
        for (Car car : dispatcher.getAvailableCars()) {
            System.out.println(car);
        }
        for (Driver driver : dispatcher.getAvailableDrivers()) {
            System.out.println(driver);
        }
    }
}