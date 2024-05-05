package Task2.AccountLevels;

import Task2.AccountLevel;
import Task2.BaseDecorator;
import Task2.Book;

import java.util.ArrayList;
import java.util.List;

public class DeluxeAccountLevel extends BaseDecorator {
    public DeluxeAccountLevel(AccountLevel accountLevel){
        super(accountLevel);
    }
    @Override
    public void buyBook(Book book) {
        System.out.println("Покупка книги " + book.getTitle());
    }

    @Override
    public void addToShoppingCart(Book book) {
        System.out.println("Книга " + book.getTitle() + " добавлена в корзину");
    }

    @Override
    public List<Book> getSpecialOffer() {
        System.out.println("Специальные предложения отправлены");
        return new ArrayList<>();
    }
}
