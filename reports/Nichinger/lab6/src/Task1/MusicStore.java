package Task1;

import java.util.ArrayList;
import java.util.List;

/*
TODO
    Singleton
    Музыкальный магазин. Должно обеспечиваться одновременное обслуживание нескольких покупателей.
    Магазин должен предоставлять широкий выбор товаров различных музыкальных направлений.
 */
public class MusicStore {
    private static MusicStore instance;
    private List<Product> products;

    private MusicStore() {
        products = new ArrayList<>();
    }

    public static MusicStore getInstance() {
        if (instance == null) {
            synchronized (MusicStore.class) {
                if (instance == null) {
                    instance = new MusicStore();
                }
            }
        }
        return instance;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void addProducts(List<Product> products){
        this.products.addAll(products);
    }

    public void removeProduct(Product product) {
        products.remove(product);
    }

    public List<Product> getProducts() {
        return new ArrayList<>(products);
    }

    public synchronized void serveCustomer(Customer customer) {
        if (products.isEmpty())
            return;
        Product product = products.get((int) Math.round(Math.random() * products.size()));
        if (customer.isProductObtainable(product)){
            customer.buyProduct(product);
        }
    }

    @Override
    public String toString() {
        return "MusicStore{" +
                "products=" + products +
                '}';
    }
}