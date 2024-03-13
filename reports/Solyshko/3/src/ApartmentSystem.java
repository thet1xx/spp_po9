import java.util.ArrayList;
import java.util.List;

public class ApartmentSystem {
    private List<Apartment> availableApartments;
    private List<Apartment> occupiedApartments;

    public ApartmentSystem() {
        this.availableApartments = new ArrayList<>();
        this.occupiedApartments = new ArrayList<>();
    }

    public void addApartment(Apartment apartment) {
        availableApartments.add(apartment);
    }

    public List<Apartment> getAvailableApartments() {
        return availableApartments;
    }

    public void displayAllApartments() {
        displayAvailableApartments();
        displayOccupiedApartments();
    }

    public void displayAvailableApartments() {
        System.out.println("Available Apartments:");
        for (Apartment apartment : availableApartments) {
            System.out.println(apartment);
        }
    }

    public void displayOccupiedApartments() {
        System.out.println("Occupied Apartments:");
        for (Apartment apartment : occupiedApartments) {
            System.out.println(apartment);
        }
    }

    public void findMatchingApartment(int numberOfRooms, int floor, double minArea) {
        for (Apartment apartment : availableApartments) {
            if (apartment.isOccupied()) {
                continue;
            }

            if (apartment.getNumberOfRooms() == numberOfRooms &&
                    apartment.getFloor() == floor &&
                    Math.abs(apartment.getTotalArea() - minArea) <= 10) {
                System.out.println("Matching Apartment found: " + apartment);
                return;
            }
        }

        System.out.println("No matching apartment found.");
    }

    public void rentApartment(Apartment apartment) {
        if (availableApartments.contains(apartment)) {
            availableApartments.remove(apartment);
            apartment.setOccupied(true);
            occupiedApartments.add(apartment);
            System.out.println("Apartment rented successfully: " + apartment);
        } else {
            System.out.println("Apartment not available for rent.");
        }
    }

    public List<Apartment> getApartmentsByNumberOfRooms(int numberOfRooms) {
        List<Apartment> result = new ArrayList<>();
        for (Apartment apartment : availableApartments) {
            if (apartment.getNumberOfRooms() == numberOfRooms) {
                result.add(apartment);
            }
        }
        return result;
    }

    public List<Apartment> getApartmentsByRoomsAndFloor(int numberOfRooms, int floorRangeStart, int floorRangeEnd) {
        List<Apartment> result = new ArrayList<>();
        for (Apartment apartment : availableApartments) {
            if (apartment.getNumberOfRooms() == numberOfRooms &&
                    apartment.getFloor() >= floorRangeStart &&
                    apartment.getFloor() <= floorRangeEnd) {
                result.add(apartment);
            }
        }
        return result;
    }

    public List<Apartment> getApartmentsByArea(double minArea) {
        List<Apartment> result = new ArrayList<>();
        for (Apartment apartment : availableApartments) {
            if (apartment.getTotalArea() > minArea) {
                result.add(apartment);
            }
        }
        return result;
    }
}
