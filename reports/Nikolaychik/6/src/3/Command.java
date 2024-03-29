public abstract class Command {
    public ATM atm;
    private double backup;

    Command(ATM atm) {
        this.atm = atm;
    }

    void backup() {
        backup = atm.getAllMoney();
    }

    public void undo() {
        atm.setAllMoney(backup);
    }

    public abstract boolean execute();
}