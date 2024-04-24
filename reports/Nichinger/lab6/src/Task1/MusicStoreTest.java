package Task1;

import java.util.List;

public class MusicStoreTest {
    public static void main(String[] args) {
        MusicStore musicStore = MusicStore.getInstance();
        musicStore.addProducts(List.of(
                new Product("Krutaya pesnya", 50),
                new Product("Spichki", 80)
        ));

        System.out.println("Music store info:");
        System.out.println(musicStore);

        Customer customer = new Customer("Kirill", 100);

        System.out.println("\nCustomer info before purchase:");
        System.out.println(customer);

        musicStore.serveCustomer(customer);

        System.out.println("\nCustomer info after purchase:");
        System.out.println(customer);
    }
}
