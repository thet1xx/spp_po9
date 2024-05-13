public class Admin extends Human {
    public Admin(String fullName){
        super(fullName);
    }

    public void blockCreditCardForExceedingCredit(CreditCard creditCard) {
            creditCard.block();
            System.out.println("Кредитная карта заблокирована Администратором " + fullName);
    }
}

