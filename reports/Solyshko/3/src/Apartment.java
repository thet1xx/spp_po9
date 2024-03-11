public class Apartment {
    private int numberOfRooms; //количество комнат;
    private double totalArea; //общая площадь;
    private int floor; //этаж;
    private String address; //адрес;
    private double rentPrice; //цена аренды.
    private boolean isOccupied; // сдается ли квартира.

    public Apartment(int numberOfRooms, double totalArea, int floor, String address, double rentPrice) {
        this.numberOfRooms = numberOfRooms;
        this.totalArea = totalArea;
        this.floor = floor;
        this.address = address;
        this.rentPrice = rentPrice;
        this.isOccupied = false;
    }

    public int getNumberOfRooms() {
        return numberOfRooms;
    }

    public double getTotalArea() {
        return totalArea;
    }

    public int getFloor() {
        return floor;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }

    @Override
    public String toString() {
        return "Apartment{" +
                "numberOfRooms=" + numberOfRooms +
                ", totalArea=" + totalArea +
                ", floor=" + floor +
                ", address='" + address + '\'' +
                ", rentPrice=" + rentPrice +
                ", isOccupied=" + (isOccupied?"Сдана":"Сдаётся") +
                '}';
    }
}
