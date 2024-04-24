package Task2;

import Task2.AccountLevels.BaseAccountLevel;
import Task2.AccountLevels.DeluxeAccountLevel;
import Task2.AccountLevels.PremiumAccountLevel;

import java.util.List;

/*
TODO
    Decorator
    Учетная запись покупателя книжного интернет-магазина. Предусмотреть различные уровни
    учетки в зависимости от активности покупателя. Дополнительные уровни добавляют
    функциональные возможности и открывают доступ к уникальным предложениям.
 */
public class Customer implements  AccountLevel{
    private AccountLevel accountLevel;

    public Customer(){
        accountLevel = new BaseAccountLevel();
    }

    @Override
    public void buyBook(Book book) {
        accountLevel.buyBook(book);
    }

    @Override
    public void addToShoppingCart(Book book) {
        accountLevel.addToShoppingCart(book);
    }

    @Override
    public List<Book> getSpecialOffer() {
        return accountLevel.getSpecialOffer();
    }

    public void toDeluxeAccount(){
        accountLevel = new DeluxeAccountLevel(accountLevel);
    }

    public void toPremiumAccount(){
        accountLevel = new PremiumAccountLevel(accountLevel);
    }
}
