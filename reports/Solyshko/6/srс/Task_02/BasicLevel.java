package Task_02;

public class BasicLevel implements ActivityLevel {
    @Override
    public void purchaseBook(Book book, CustomerAccount customer) {
        System.out.println("Purchasing book: " + book.getTitle());
        customer.incrementPoints(book.getPoints());
        checkUpgrade(customer);
    }

    @Override
    public void participateInContest(CustomerAccount customer) {
        System.out.println("Contest participation available for premium and elite levels.");
    }

    private void checkUpgrade(CustomerAccount customer) {
        if (customer.getPoints() >= 5) {
            customer.setActivityLevel(new PremiumLevel());
            System.out.println("Congratulations! You have been upgraded to Premium Level.");
        }
    }
}
