package Lab4_1;

public class Lab4_1 {

    public static void main(String[] args) {
        City city = new City("Москва");

        city.addAddress(new City.Address("проспект", "Мира"));
        city.addAddress(new City.Address("улица", "Ленина"));
        city.addAddress(new City.Address("площадь", "Красная"));

        System.out.println(city);
    }
}
