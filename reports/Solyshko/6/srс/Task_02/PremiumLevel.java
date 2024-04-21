package Task_02;

import java.util.Random;

public class PremiumLevel implements ActivityLevel {
    @Override
    public void purchaseBook(Book book, CustomerAccount customer) {
        System.out.println("Purchasing book: " + book.getTitle());
        customer.incrementPoints(book.getPoints());
        checkUpgrade(customer);
    }

    @Override
    public void participateInContest(CustomerAccount customer) {
        Random random = new Random();
        int result = random.nextInt(100);
        if (result < 30) {
            System.out.println("You won the contest");
            customer.addBalance(20);
        } else {
            System.out.println("Better luck next time! No prize this time.");
        }
    }

    private void checkUpgrade(CustomerAccount customer) {
        if (customer.getPoints() >= 10) {
            customer.setActivityLevel(new EliteLevel());
            System.out.println("Congratulations! You have been upgraded to Elite Level.");
        }
    }
}
