package Task2;

import java.util.ArrayList;
import java.util.List;

public class BaseDecorator implements AccountLevel{
    private AccountLevel wrappee;

    public BaseDecorator(AccountLevel accountLevel) {
        this.wrappee = accountLevel;
    }

    @Override
    public void buyBook(Book book) {
        wrappee.buyBook(book);
    }

    @Override
    public void addToShoppingCart(Book book) {
        wrappee.addToShoppingCart(book);
    }

    @Override
    public List<Book> getSpecialOffer() {
        return wrappee.getSpecialOffer();
    }
}
