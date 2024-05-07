import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RentalSystem {
    private List<Car> cars;

    public RentalSystem() {
        cars = new ArrayList<>();
        String fileName = "C:\\Users\\user\\IdeaProjects\\untitled2\\src\\inputcars.txt";
        loadCarsFromFile(fileName);
    }

    private void loadCarsFromFile(String fileName) {
        try {
            File file = new File(fileName);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");
                int id = Integer.parseInt(parts[0]);
                String brand = parts[1];
                String model = parts[2];
                int year = Integer.parseInt(parts[3]);
                String color = parts[4];
                double price = Double.parseDouble(parts[5]);
                String registrationNumber = parts[6];
                String plateNumber = parts[7];
                String renterName = "";
                String renterPassport = "";
                if (parts.length > 8) {
                    renterName = parts[8];
                    renterPassport = parts[9];
                }
                cars.add(new Car(id, brand, model, year, color, price, registrationNumber, plateNumber, renterName, renterPassport));
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + fileName);
            e.printStackTrace();
        }
    }

    public void printAllCars() {
        for (Car car : cars) {
            System.out.println(car);
        }
    }

    public void printCarsByBrand(String brand) {
        for (Car car : cars) {
            if (car.getBrand().equalsIgnoreCase(brand)) {
                System.out.println(car);
            }
        }
    }

    public void printCarsByModelAndAge(String model, int age) {
        int currentYear = 2024;
        for (Car car : cars) {
            if (car.getModel().equalsIgnoreCase(model) && (currentYear - car.getYear()) > age) {
                System.out.println(car);
            }
        }
    }

    public void printCarsByYearAndPrice(int year, double minPrice) {
        for (Car car : cars) {
            if (car.getYear() == year && car.getPrice() > minPrice) {
                System.out.println(car);
            }
        }
    }

    public void printRentedCars() {
        for (Car car : cars) {
            if (!car.getRenterName().isEmpty()) {
                System.out.println(car);
            }
        }
    }

    public void printRentedCarsWithRenterInfo() {
        for (Car car : cars) {
            if (!car.getRenterName().isEmpty()) {
                System.out.println(car);
            }
        }
    }


}