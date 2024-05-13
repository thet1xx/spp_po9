class Client {
    private String name;
    private String phoneNumber;
    private BankAccount bankAccount;
    private CreditCard creditCard;

    public Client(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setBankAccount(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    public void setCreditCard(CreditCard creditCard) {
        this.creditCard = creditCard;
    }

    public void payOrder(Order order) {
        System.out.println("Имя клиента: " + name);
        System.out.println("Номер телефона: " + phoneNumber);
        System.out.println("Счет в банке: " + bankAccount.getAccountNumber() + ", Баланс: " + bankAccount.getBalance());
        System.out.println("Кредитная карта: " + creditCard.getCardNumber() + ", Доступный кредит: " + creditCard.getAvailableCredit());
        System.out.println("Клиент " + name + " оплачивает заказ на сумму " + order.getAmount() + " с помощью кредитной карты.");
    }

    public void makePaymentToAccount(BankAccount recipientAccount, double amount) {
        System.out.println("Имя клиента: " + name);
        System.out.println("Номер телефона: " + phoneNumber);
        System.out.println("Счет в банке: " + bankAccount.getAccountNumber() + ", Баланс: " + bankAccount.getBalance());
        System.out.println("Кредитная карта: " + creditCard.getCardNumber() + ", Доступный кредит: " + creditCard.getAvailableCredit());
        System.out.println("Клиент " + name + " делает платеж на другой счет на сумму " + amount + " с помощью счета в банке.");
    }

    public void blockCreditCard() {
        if (creditCard != null) {
            creditCard.blockCard();
            System.out.println("Кредитная карта клиента " + name + " была заблокирована.");
        }
    }

    public void cancelBankAccount() {
        if (bankAccount != null) {
            bankAccount.cancelAccount();
            System.out.println("Счет клиента " + name + " был аннулирован.");
        }
    }
}

class BankAccount {
    private String accountNumber;
    private double balance;

    public BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public void topUp(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
        } else {
            System.out.println("Недостаточно средств на счете");
        }
    }

    public void cancelAccount() {
        // Логика аннулирования счета
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }
}

class CreditCard {
    private String cardNumber;
    private double creditLimit;
    private double availableCredit;
    private boolean blocked;

    public CreditCard(String cardNumber, double creditLimit) {
        this.cardNumber = cardNumber;
        this.creditLimit = creditLimit;
        this.availableCredit = creditLimit;
    }

    public boolean checkCreditExceed(double amount) {
        return (availableCredit - amount) < 0;
    }

    public void blockCard() {
        blocked = true;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public double getAvailableCredit() {
        return availableCredit;
    }
}

class Order {
    private String orderNumber;
    private double amount;

    public Order(String orderNumber, double amount) {
        this.orderNumber = orderNumber;
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }
}

class Administrator {
    public void blockCardForOverdraft(Client client) {
        System.out.println("Администратор заблокировал карту клиента " + client.getName() + " за превышение кредита.");
    }
}

public class Main3 {
    public static void main(String[] args) {
        // Пример использования системы
        Client client = new Client("John Doe", "+123456789");
        BankAccount bankAccount = new BankAccount("123456", 1000.0);
        CreditCard creditCard = new CreditCard("789012345678", 500.0);

        client.setBankAccount(bankAccount);
        client.setCreditCard(creditCard);

        Order order = new Order("0001", 200.0);
        client.payOrder(order);

        BankAccount recipientAccount = new BankAccount("654321", 0.0);
        client.makePaymentToAccount(recipientAccount, 100.0);

        Administrator administrator = new Administrator();
        administrator.blockCardForOverdraft(client);
    }
}
