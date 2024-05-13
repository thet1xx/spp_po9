public class ATM {
    private ATMState state;
    private int totalCash;
    public ATM(int totalCash) {
        this.totalCash = totalCash;
        this.state = new WaitingState(this);
    }
    public void setState(ATMState state) {
        this.state = state;
    }
    public void insertCard() {
        state.insertCard();
    }
    public void enterPin(int pin) {
        state.enterPin(pin);
    }
    public void withdrawCash(int amount) {
        state.withdrawCash(amount);
    }
    public void ejectCard() {
        state.ejectCard();
    }
    public int getTotalCash() {
        return totalCash;
    }
    public void setTotalCash(int totalCash) {
        this.totalCash = totalCash;
    }
    public boolean getPin() {
        return true;
    }
}
