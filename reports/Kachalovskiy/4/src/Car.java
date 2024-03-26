package Lab4_3;

public class Car {

    private String model;
    private String licensePlate;
    private boolean available;

    public Car(String model, String licensePlate) {
        this.model = model;
        this.licensePlate = licensePlate;
        this.available = true;
    }

    public String getModel() {
        return model;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return "Автомобиль: " + model + " (" + licensePlate + ")";
    }
}

