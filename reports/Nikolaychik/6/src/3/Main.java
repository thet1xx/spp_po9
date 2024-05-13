interface ATMState {
    void insertCard();
    void enterPin(int pin);
    void withdrawCash(int amount);
    void ejectCard();
}

class WaitingState implements ATMState {
    private ATM atm = null;
    public WaitingState(ATM atm){
        this.atm = atm;
    }
    public void insertCard() {
        System.out.println("Card inserted.");
        atm.setState(new AuthenticatedState(atm));
    }

    public void enterPin(int pin) {
        System.out.println("Please insert card first.");
    }

    public void withdrawCash(int amount) {
        System.out.println("Please insert card and enter pin first.");
    }

    public void ejectCard() {
        System.out.println("No card to eject.");
    }
}



class AuthenticatedState implements ATMState {
    private ATM atm;

    public AuthenticatedState(ATM atm) {
        this.atm = atm;
    }

    public void insertCard() {
        System.out.println("Card already inserted.");
    }

    public void enterPin(int pin) {
        if (atm.getPin()) {
            System.out.println("PIN correct.");
            atm.setState(new TransactionState(atm));
        } else {
            System.out.println("Invalid PIN.");
            atm.setState(new BlockedState());
        }
    }

    public void withdrawCash(int amount) {
        System.out.println("Please enter PIN first.");
    }

    public void ejectCard() {
        System.out.println("Card ejected.");
        atm.setState(new WaitingState(atm));
    }
}

class TransactionState implements ATMState {
    private ATM atm;

    public TransactionState(ATM atm) {
        this.atm = atm;
    }

    public void insertCard() {
        System.out.println("Card already inserted.");
    }

    public void enterPin(int pin) {
        System.out.println("PIN already entered.");
    }

    public void withdrawCash(int amount) {
        if (amount <= atm.getTotalCash()) {
            System.out.println("Cash withdrawn: " + amount);
            atm.setTotalCash(atm.getTotalCash() - amount);
        } else {
            System.out.println("Not enough cash in ATM.");
        }
    }

    public void ejectCard() {
        System.out.println("Card ejected.");
        atm.setState(new WaitingState(atm));
    }
}

// Конкретное состояние банкомата: блокировка
class BlockedState implements ATMState {
    public void insertCard() {
        System.out.println("Card cannot be inserted. ATM blocked.");
    }

    public void enterPin(int pin) {
        System.out.println("PIN cannot be entered. ATM blocked.");
    }

    public void withdrawCash(int amount) {
        System.out.println("Cash cannot be withdrawn. ATM blocked.");
    }

    public void ejectCard() {
        System.out.println("Card cannot be ejected. ATM blocked.");
    }
}

public class Main {
    public static void main(String[] args) {
        ATM atm = new ATM(1000);
        atm.insertCard();
        atm.enterPin(1234); // Assuming correct PIN
        atm.withdrawCash(500);
        atm.withdrawCash(500000);
        atm.ejectCard();
    }
}