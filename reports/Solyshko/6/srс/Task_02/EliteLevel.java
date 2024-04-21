package Task_02;

import java.util.Random;

public class EliteLevel implements ActivityLevel {
    @Override
    public void purchaseBook(Book book, CustomerAccount customer) {
        System.out.println("Purchasing book: " + book.getTitle());
        customer.incrementPoints(book.getPoints());
    }

    @Override
    public void participateInContest(CustomerAccount customer) {
        Random random = new Random();
        int result = random.nextInt(100);
        if (result < 50) {
            System.out.println("You won the contest");
            customer.addBalance(50);
        } else {
            System.out.println("Better luck next time! No prize this time.");
        }
    }
}
