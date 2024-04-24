import java.util.ArrayList;
import java.util.List;

 enum Type  {
    square,
    street,
    boulevard,
    avenue,
}
public class City {

    private String name;
    private List<Address> addresses;


    public City(String name) {
        this.name = name;
        this.addresses = new ArrayList<>();
    }

    public void addAddress(Address address) {
        addresses.add(address);
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    @Override
    public String toString() {
        return "Город: " + name + "\n" +
                "Адреса:\n" +
                addresses;
    }

    public static class Address {

        Type type;
        private String name;

        public Address(Type type, String name) {
            this.type = type;
            this.name = name;
        }

        @Override
        public String toString() {
            return type + " " + name;
        }
    }
}