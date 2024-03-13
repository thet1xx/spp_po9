import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.List;

public class MainApartmentSystem {
    public static void main(String[] args) {
        ApartmentSystem system = new ApartmentSystem();

        String path = "D:\\Githab_Repositories\\spp_po9\\reports\\Solyshko\\3\\src\\apartments.txt";

        // Загрузка данных из файла
        loadApartmentsFromFile(path, system);

        // Отображение всех квартир
        system.displayAllApartments();

        // Аренда квартиры
        List<Apartment> availableApartments = system.getAvailableApartments();
        if (!availableApartments.isEmpty()) {
            Apartment apartmentToRent = availableApartments.get(0);
            system.rentApartment(apartmentToRent);
        } else {
            System.out.println("No available apartments to rent.");
        }

        // Отображение всех квартир после аренды
        system.displayAllApartments();

        // Поиск подходящей квартиры
        system.findMatchingApartment(2, 3, 80.0);

        system.findMatchingApartment(2, 4, 75.0);

        // Список квартир с заданным числом комнат
        List<Apartment> apartmentsByNumberOfRooms = system.getApartmentsByNumberOfRooms(2);
        System.out.println("Apartments with 2 rooms: " + apartmentsByNumberOfRooms);

        // Список квартир с заданным числом комнат и этажем в заданном промежутке
        List<Apartment> apartmentsByRoomsAndFloor = system.getApartmentsByRoomsAndFloor(2, 1, 5);
        System.out.println("Apartments with 2 rooms and floor between 1 and 5: " + apartmentsByRoomsAndFloor);

        // Список квартир с площадью, превосходящей заданную
        List<Apartment> apartmentsByArea = system.getApartmentsByArea(80.0);
        System.out.println("Apartments with area greater than 80: " + apartmentsByArea);
    }

    private static void loadApartmentsFromFile(String fileName, ApartmentSystem system) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(", ");
                if (parts.length == 5) {
                    int numberOfRooms = Integer.parseInt(parts[0]);
                    double totalArea = Double.parseDouble(parts[1]);
                    int floor = Integer.parseInt(parts[2]);
                    String address = parts[3];
                    double rentPrice = Double.parseDouble(parts[4]);

                    Apartment apartment = new Apartment(numberOfRooms, totalArea, floor, address, rentPrice);
                    system.addApartment(apartment);
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
