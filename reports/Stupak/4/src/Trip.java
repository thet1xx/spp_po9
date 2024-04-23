package Lab4_3;

public class Trip {

    private String destination;
    private Car car;
    private Driver driver;
    private boolean isEnd;

    public Trip(String destination, Car car, Driver driver) {
        this.destination = destination;
        this.car = car;
        this.driver = driver;
        this.isEnd = false;
    }
    public boolean getStatus() {
        return isEnd;
    }

    public void setStatus(boolean isEnd) {
        this.isEnd = isEnd;
    }
    public String getDestination() {
        return destination;
    }


    public Car getCar() {
        return car;
    }

    public Driver getDriver() {
        return driver;
    }

    @Override
    public String toString() {
        return "Рейс: " + destination + " (" + car + ", " + driver + ")";
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }
}
