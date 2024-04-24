public class Lab4_1 {

    public static void main(String[] args) {
        City city = new City("Москва");

        city.addAddress(new City.Address(Type.square, "Мира"));
        city.addAddress(new City.Address(Type.avenue, "Ленина"));
        city.addAddress(new City.Address(Type.street, "Красная"));

        System.out.println(city);
    }
}