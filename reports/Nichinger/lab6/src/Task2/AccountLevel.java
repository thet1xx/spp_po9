package Task2;

import java.util.List;

public interface AccountLevel {
    public void buyBook(Book book);
    public void addToShoppingCart(Book book);
    public List<Book> getSpecialOffer();
}
