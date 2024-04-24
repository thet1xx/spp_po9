package Task3.States;

import Task3.Printer;
import Task3.State;

public class JammingState extends State {
    public JammingState(Printer printer) {
        super(printer);
        stateName = "JammingState";
    }

    @Override
    public void print(int numPaper) {
    }

    @Override
    public void loadPaper(int numPaper) {
    }

    @Override
    public void extractJammingPaper() {
        printer.changeState(new WaitingState(printer));
    }

    @Override
    public void refillCartridge() {
    }
}
