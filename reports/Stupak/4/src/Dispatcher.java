package Lab4_3;

import java.util.ArrayList;
import java.util.List;

public class Dispatcher {

    private List<Car> cars;
    private List<Driver> drivers;
    private List<Trip> trips;

    public Dispatcher() {
        this.cars = new ArrayList<>();
        this.drivers = new ArrayList<>();
        this.trips = new ArrayList<>();
    }

    public void addCar(Car car) {
        cars.add(car);
    }

    public void addDriver(Driver driver) {
        drivers.add(driver);
    }

    public void addTrip(Trip trip) {
        trips.add(trip);
    }

    public void assignTrip(Trip trip) {
        if (!(trip.getStatus())) {
            Car car = findAvailableCar();
            Driver driver = findAvailableDriver();
            driver.setTrip(trip);
            trip.setCar(car);
            trip.setDriver(driver);
            car.setAvailable(false);
            driver.setAvailable(false);
            System.out.println("На рейс назначен: " + driver.toString() + " " + car.toString());
        }
    }

    private Car findAvailableCar() {
        for (Car car : cars) {
            if (car.isAvailable()) {
                return car;
            }
        }
        return null;
    }

    private Driver findAvailableDriver() {
        for (Driver driver : drivers) {
            if (driver.isAvailable()) {
                return driver;
            }
        }
        return null;
    }

    public void removeDriver(Driver driver) {
        drivers.remove(driver);
    }



    public List<Car> getAvailableCars() {
        List<Car> result = new ArrayList<Car>();
        for (Car car : cars){
            if (car.isAvailable())
                result.add(car);
        }
        return result;
    }

    public List<Driver> getAvailableDrivers() {
        List<Driver> result = new ArrayList<Driver>();
        for (Driver driver : drivers){
            if (driver.isAvailable())
                result.add(driver);
        }
        return result;
    }
}
