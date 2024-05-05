import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BusPark busPark = new BusPark();
        busPark.loadBusesFromFile("BusInfo.txt");

        while (true) {
            // Выводим меню
            System.out.println("\nМеню:");
            System.out.println("1. Просмотреть все автобусы");
            System.out.println("2. Просмотреть автобусы выехавшие из парка");
            System.out.println("3. Просмотреть автобусы оставшиеся в парке");
            System.out.println("4. Просмотреть автобусы по номеру маршрута");
            System.out.println("5. Просмотреть автобусы эксплуатируемые более 10 лет");
            System.out.println("6. Просмотреть автобусы с пробегом более 100000 км");
            System.out.println("7. Выйти");

            // Получаем выбор пользователя
            System.out.print("Выберите пункт меню: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // считываем лишний перевод строк

            switch (choice) {
                case 1:
                    // Выводим все автобусы
                    System.out.println("\nВсе автобусы:");
                    busPark.printBuses(busPark.getAllBuses());
                    break;
                case 2:
                    // Выводим автобусы, выехавшие из парка
                    System.out.println("\nАвтобусы, выехавшие из парка:");
                    busPark.printBuses(busPark.getBusesLeftPark());
                    break;
                case 3:
                    // Выводим автобусы, оставшиеся в парке
                    System.out.println("\nАвтобусы, оставшиеся в парке:");
                    busPark.printBuses(busPark.getBusesInPark());
                    break;
                case 4:
                    // Запрашиваем номер маршрута у пользователя и выводим соответствующие автобусы
                    System.out.print("Введите номер маршрута: ");
                    String routeNumber = scanner.nextLine();
                    System.out.println("\nАвтобусы на маршруте " + routeNumber + ":");
                    busPark.printBuses(busPark.getBusesByRouteNumber(routeNumber));
                    break;
                case 5:
                    // Выводим автобусы, эксплуатируемые более 10 лет
                    System.out.println("\nАвтобусы, эксплуатируемые более 10 лет:");
                    busPark.printBuses(busPark.getBusesOverTenYears());
                    break;
                case 6:
                    // Выводим автобусы с пробегом более 100000 км
                    System.out.println("\nАвтобусы с пробегом более 100000 км:");
                    busPark.printBuses(busPark.getBusesWithMileageOver100000());
                    break;
                case 7:
                    // Завершаем программу
                    System.out.println("Выход из программы.");
                    return;
                default:
                    // Сообщаем о неверном выборе
                    System.out.println("Неверный выбор. Попробуйте снова.");
            }
        }
    }
}

class BusPark {
    private List<Bus> buses;

    public BusPark() {
        this.buses = new ArrayList<>();
    }

    // Метод для загрузки данных об автобусах из файла
    public void loadBusesFromFile(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length == 7) {
                    String driverName = parts[0];
                    String busNumber = parts[1];
                    String routeNumber = parts[2];
                    String brand = parts[3];
                    int startYear = Integer.parseInt(parts[4]);
                    int mileage = Integer.parseInt(parts[5]);
                    String location = parts[6];
                    Bus bus = new Bus(driverName, busNumber, routeNumber, brand, startYear, mileage, location);
                    buses.add(bus);
                } else {
                    // Выводим сообщение об ошибке, если формат строки неверный
                    System.err.println("Неверный формат строки: " + line);
                }
            }
        } catch (IOException e) {
            // Выводим сообщение об ошибке, если произошла ошибка чтения файла
            System.err.println("Ошибка чтения файла: " + e.getMessage());
        }
    }

    // Метод для получения всех автобусов
    public List<Bus> getAllBuses() {
        return new ArrayList<>(buses);
    }

    // Метод для получения списка автобусов, выехавших из парка
    public List<Bus> getBusesLeftPark() {
        List<Bus> leftPark = new ArrayList<>();
        for (Bus bus : buses) {
            if (bus.getLocation().equalsIgnoreCase("маршрут")) {
                leftPark.add(bus);
            }
        }
        return leftPark;
    }

    // Метод для получения списка автобусов, оставшихся в парке
    public List<Bus> getBusesInPark() {
        List<Bus> inPark = new ArrayList<>();
        for (Bus bus : buses) {
            if (bus.getLocation().equalsIgnoreCase("парк")) {
                inPark.add(bus);
            }
        }
        return inPark;
    }

    // Метод для получения списка автобусов по номеру маршрута
    public List<Bus> getBusesByRouteNumber(String routeNumber) {
        List<Bus> byRouteNumber = new ArrayList<>();
        for (Bus bus : buses) {
            if (bus.getRouteNumber().equalsIgnoreCase(routeNumber)) {
                byRouteNumber.add(bus);
            }
        }
        return byRouteNumber;
    }

    // Метод для получения списка автобусов, эксплуатируемых более 10 лет
    public List<Bus> getBusesOverTenYears() {
        List<Bus> overTenYears = new ArrayList<>();
        int currentYear = 2024; // Предположим, что текущий год 2024
        for (Bus bus : buses) {
            if (currentYear - bus.getStartYear() > 10) {
                overTenYears.add(bus);
            }
        }
        return overTenYears;
    }

    // Метод для получения списка автобусов с пробегом более 100000 км
    public List<Bus> getBusesWithMileageOver100000() {
        List<Bus> over100000 = new ArrayList<>();
        for (Bus bus : buses) {
            if (bus.getMileage() > 100000) {
                over100000.add(bus);
            }
        }
        return over100000;
    }

    // Метод для вывода списка автобусов
    public void printBuses(List<Bus> buses) {
        for (Bus bus : buses) {
            System.out.println(bus);
        }
    }
}

class Bus {
    private String driverName;
    private String busNumber;
    private String routeNumber;
    private String brand;
    private int startYear;
    private int mileage;
    private String location;

    // Конструктор класса
    public Bus(String driverName, String busNumber, String routeNumber, String brand, int startYear, int mileage, String location) {
        this.driverName = driverName;
        this.busNumber = busNumber;
        this.routeNumber = routeNumber;
        this.brand = brand;
        this.startYear = startYear;
        this.mileage = mileage;
        this.location = location;
    }

    // Геттеры и сеттеры для полей класса
    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getBusNumber() {
        return busNumber;
    }

    public void setBusNumber(String busNumber) {
        this.busNumber = busNumber;
    }

    public String getRouteNumber() {
        return routeNumber;
    }

    public void setRouteNumber(String routeNumber) {
        this.routeNumber = routeNumber;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getStartYear() {
        return startYear;
    }

    public void setStartYear(int startYear) {
        this.startYear = startYear;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    // Переопределение метода toString для класса Bus
    @Override
    public String toString() {
        return "Bus:" +
                "ФИО водителя='" + driverName + '\'' +
                ", Номер автобуса='" + busNumber + '\'' +
                ", Номер маршрута='" + routeNumber + '\'' +
                ", Марка='" + brand + '\'' +
                ", Год начала эксплуатации=" + startYear +
                ", Пробег=" + mileage +
                ", Местонахождение='" + location + '\'';
    }
}
