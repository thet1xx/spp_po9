package Task3;

public abstract class State implements PrinterFunctions{
    protected Printer printer;
    protected String stateName = "None";

    public State(Printer printer){
        this.printer = printer;
    }

    public String getStateName() {
        return stateName;
    }

    @Override
    public String toString() {
        return "State{" +
                "stateName='" + stateName + '\'' +
                '}';
    }
}
