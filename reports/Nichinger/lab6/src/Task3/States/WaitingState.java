package Task3.States;

import Task3.Printer;
import Task3.State;

public class WaitingState extends State {
    public WaitingState(Printer printer) {
        super(printer);
        stateName = "WaitingState";
    }

    @Override
    public void print(int numPaper) {
        printer.changeState(new PrintingState(printer));
        printer.print(numPaper);
    }

    @Override
    public void loadPaper(int numPaper) {
        printer.setPagesCount(printer.getPagesCount() + numPaper);
    }

    @Override
    public void extractJammingPaper() {
    }

    @Override
    public void refillCartridge() {
        printer.setPaintPercentage(100);
    }
}