package Task2;

public class BookStoreTest {
    public static void main(String[] args) {
        Customer customer = new Customer();
        Book book = new Book("Voina i mir", "Privet", 50);

        System.out.println("Базовый аккаунт:");
        customer.buyBook(book);
        customer.addToShoppingCart(book);
        customer.getSpecialOffer();

        System.out.println("\nПремиум аккаунт:");
        customer.toPremiumAccount();
        customer.buyBook(book);
        customer.addToShoppingCart(book);
        customer.getSpecialOffer();

        System.out.println("\nДелюкс аккаунт:");
        customer.toDeluxeAccount();
        customer.buyBook(book);
        customer.addToShoppingCart(book);
        customer.getSpecialOffer();
    }
}
