import java.util.ArrayList;
import java.util.List;

class Product {
    private String name;
    private double price;
    private String description;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

class Cart {
    private List<Product> products;

    public Cart() {
        products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public double calculateTotalPrice() {
        double total = 0;
        for (Product product : products) {
            total += product.getPrice();
        }
        return total;
    }
}

class Administrator {
    static private List<String> paymentRegistry = new ArrayList<>();
    static private List<String> blacklist = new ArrayList<>();

    public static void registerPayment(String clientName, double amount) {
        paymentRegistry.add("Client: " + clientName + ", Amount Paid: $" + amount);
        System.out.println("Client: " + clientName + ", Amount Paid: $" + amount);
    }

    public static void addToBlacklist(String clientName) {
        blacklist.add(clientName);
    }

    public static boolean isBlacklisted(String clientName) {
        return blacklist.contains(clientName);
    }

    public static void addProductDescription(Product product, String description) {
        product.setDescription(description);
    }

}

class Client {
    private String name;
    private double money;
    private Cart cart;

    public Client(String name, double money) {
        this.name = name;
        this.money = money;
        this.cart = new Cart();
    }

    public void addProductToCart(Product product) {
        cart.addProduct(product);
    }

    public void pay() {
        double totalPrice = cart.calculateTotalPrice();
        if (totalPrice <= money) {
            money -= totalPrice;
            Administrator.registerPayment(name, totalPrice);
        } else {
            Administrator.addToBlacklist(name);
            System.out.println("Client " + name + " doesn't have enough money " +
                    "and has been added to the blacklist.");
        }
    }
}

public class Task3{
    public static void main(String[] args) {
        Client client1 = new Client("Maria", 2000);
        Client client2 = new Client("Vera", 50);

        Product product1 = new Product("Laptop", 1200);
        Product product2 = new Product("Smartphone", 800);

        Administrator.addProductDescription(product1,
                "High-performance laptop with SSD storage.");
        Administrator.addProductDescription(product2,
                "Latest smartphone with dual-camera setup.");

        client1.addProductToCart(product1);
        client1.addProductToCart(product2);

        client2.addProductToCart(product1);

        client1.pay(); // Maria has enough money to pay for both products
        client2.pay(); // Vera doesn't have enough money and will be blacklisted

        // Checking if Vera is blacklisted
        System.out.println("Is Vera blacklisted? " +
                Administrator.isBlacklisted("Vera"));

        // Retrieving product descriptions
        System.out.println(product1.getName() + " Description: " + product1.getDescription());
        System.out.println(product2.getName() + " Description: " + product2.getDescription());
    }
}
