public class Test {
    public static void main(String[] args) {
        RentalSystem rentalSystem = new RentalSystem();
        System.out.println("All cars:");
        rentalSystem.printAllCars();
        System.out.println("\nCars by brand 'Toyota':");
        rentalSystem.printCarsByBrand("Toyota");
        System.out.println("\nCars by model 'Camry' and more than 5 years old:");
        rentalSystem.printCarsByModelAndAge("Camry", 5);
        System.out.println("\nCars of 2018 with price more than $15000:");
        rentalSystem.printCarsByYearAndPrice(2018, 15000);
        System.out.println("\nRented cars:");
        rentalSystem.printRentedCars();
        System.out.println("\nRented cars with renter information:");
        rentalSystem.printRentedCarsWithRenterInfo();
    }
}
