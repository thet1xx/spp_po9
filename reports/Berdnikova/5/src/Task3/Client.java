public class Client extends Human{
    private Account account;
    private CreditCard creditCard;

    public Client(String fullName, Account account, CreditCard creditCard) {
        super(fullName);
        this.account = account;
        this.creditCard = creditCard;
    }

    public void makePayment(Order order) {
        double totalPrice = order.getTotalPrice();
        if (creditCard.isBlocked()){
            System.out.println("Карта заблокирована. Невозможно провести операцию");
            return;
        }
        if( creditCard.getAvailableCredit() >= totalPrice) {
            creditCard.increaseDebt(totalPrice);
            order.setPaid(true);
            System.out.println("Оплата заказа " + fullName + " прошла успешно");
        } else {
            System.out.println("Недостаточно средств на кредитной карте.");
        }
    }

    public void transferMoney(double amount, Account recipientAccount) {
        if (creditCard.isBlocked()){
            System.out.println("Карта заблокирована. Невозможно провести операцию");
            return;
        }
        if (account.getBalance() >= amount) {
            account.withdraw(amount);
            recipientAccount.deposit(amount);
            System.out.println("Перевод денег со счета " +fullName + " прошел успешно: " + amount);
        } else {
            System.out.println("Недостаточно средств на счете.");
        }
    }

    public void blockCreditCard() {
        creditCard.block();
        System.out.println("Кредитная карта заблокирована Клиентом " + fullName);
    }

    public void cancelAccount() {
        account.cancel();
    }

}
