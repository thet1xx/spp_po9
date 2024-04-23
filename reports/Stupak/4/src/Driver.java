package Lab4_3;

public class Driver {

    private String name;
    private boolean available;

    private Trip trip;
    public Driver(String name) {
        this.name = name;
        this.available = true;
    }
    public void sendCarToRepair(){
        if (trip !=null){
            trip.getCar().setAvailable(false);
        }
    }

    public void setTrip(Trip trip){
        this.trip=trip;
    }
    public void markTripCompleted() {
        if (trip !=null){
            trip.setStatus(true);
            this.available=true;
            trip.getCar().setAvailable(true);
            return;
        }
       System.out.println("У водителя нет рейса");
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
