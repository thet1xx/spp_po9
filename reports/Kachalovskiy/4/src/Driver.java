package Lab4_3;

public class Driver {

    private String name;
    private boolean available;

    public Driver(String name) {
        this.name = name;
        this.available = true;
    }

    public String getName() {
        return name;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return "Водитель: " + name;
    }
}
