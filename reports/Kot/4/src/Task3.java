import java.util.ArrayList;
import java.util.List;

// Интерфейс для обработки оплаты заказа
interface PaymentProcess {
    void pay();
}

// Абстрактный класс, представляющий товар
abstract class Product {
    protected String name;
    protected double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public abstract String getDescription();
}

// Класс, представляющий товар
class Item extends Product {
    private String description;

    public Item(String name, double price, String description) {
        super(name, price);
        this.description = description;
    }

    @Override
    public String getDescription() {
        return description;
    }
}

// Класс, представляющий заказ на товары
class Order implements PaymentProcess {
    private List<Product> products;
    private boolean paid = false;

    public Order() {
        products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void removeProduct(Product product) {
        products.remove(product);
    }

    public double calculateTotalPrice() {
        double total = 0;
        for (Product product : products) {
            total += product.price;
        }
        return total;
    }

    @Override
    public void pay() {
        paid = true;
    }

    public boolean isPaid() {
        return paid;
    }
}

// Класс, представляющий продажу товаров
class Sale {
    private Order order;
    private boolean registered;

    public Sale(Order order) {
        this.order = order;
    }

    public void registerSale() {
        registered = true;
    }

    public boolean isRegistered() {
        return registered;
    }
}

// Класс, представляющий администратора магазина
class Administrator {
    private List<String> blackList;
    private List<Product> products;

    public void addProductInfo(Product product) {
        products.add(product);
    }

    public List<Product> getProducts() {
        return products;
    }

    public Administrator() {
        blackList = new ArrayList<>();
        products = new ArrayList<>();
    }

    public void addToBlackList(String clientName) {
        blackList.add(clientName);
    }

    public boolean isBlackListed(String clientName) {
        return blackList.contains(clientName);
    }

    public void registerSale(Sale sale) {
        sale.registerSale();
    }
}

// Класс, представляющий клиента магазина
class Client {
    private String name;
    private Order currentOrder;

    public Client(String name) {
        this.name = name;
    }

    public void createOrder() {
        currentOrder = new Order();
    }

    public Order getCurrentOrder() {
        return currentOrder;
    }

    public void addToOrder(Product product) {
        currentOrder.addProduct(product);
    }

    public void removeFromOrder(Product product) {
        currentOrder.removeProduct(product);
    }

    public double checkout() {
        double totalPrice = currentOrder.calculateTotalPrice();
        currentOrder.pay();
        return totalPrice;
    }

    public String getName() {
        return this.name;
    }
}

public class Task3 {
    public static void main(String[] args) {
        Administrator admin = new Administrator();

        Product item1 = new Item("Ноутбук", 1000.0, "Мощный ноутбук для работы и игр");
        Product item2 = new Item("Смартфон", 500.0, "Современный смартфон с хорошей камерой");
        Product item3 = new Item("Планшет", 300.0, "Легкий и компактный планшет для чтения и просмотра видео");

        admin.addProductInfo(item1);
        admin.addProductInfo(item2);
        admin.addProductInfo(item3);

        // Проверяем, что информация о товарах добавлена успешно
        List<Product> productList = admin.getProducts();
        for (Product product : productList) {
            System.out.println(product.getDescription());
        }

        Client client = new Client("Иван");
        client.createOrder();
        client.addToOrder(item1);
        client.addToOrder(item2);
        client.addToOrder(item3);
        client.removeFromOrder(item3);

        System.out.println("Before chekout (status isPaid): " + client.getCurrentOrder().isPaid());
        double totalPrice = client.checkout();
        System.out.println("Итоговая сумма заказа: $" + totalPrice);
        System.out.println("After chekout (status isPaid): " + client.getCurrentOrder().isPaid());

        Sale sale = new Sale(client.getCurrentOrder());
        admin.registerSale(sale);
        System.out.println("Is sale registered? -- " + sale.isRegistered());

        admin.addToBlackList(client.getName());

        boolean blackListed = admin.isBlackListed(client.getName());
        if (blackListed) {
            System.out.println(client.getName() + " находится в черном списке.");
        }
    }
}

