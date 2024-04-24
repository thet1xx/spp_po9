package Task2.AccountLevels;

import Task2.AccountLevel;
import Task2.Book;

import java.util.ArrayList;
import java.util.List;

public class BaseAccountLevel implements AccountLevel {
    @Override
    public void buyBook(Book book) {
        System.out.println("Покупка книги " + book.getTitle());
    }

    @Override
    public void addToShoppingCart(Book book) {
        System.out.println("Корзина недоступна");
    }

    @Override
    public List<Book> getSpecialOffer() {
        System.out.println("Специальные предложения недоступны");
        return new ArrayList<>();
    }
}
