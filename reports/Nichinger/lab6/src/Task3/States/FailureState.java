package Task3.States;

import Task3.Printer;
import Task3.State;

public class FailureState extends State {
    public FailureState(Printer printer) {
        super(printer);
        stateName = "FailureState";
    }

    @Override
    public void print(int numPaper) {
    }

    @Override
    public void loadPaper(int numPaper) {
        printer.setPagesCount(printer.getPagesCount() + numPaper);
        if (isPrintingAvailable())
            printer.changeState(new WaitingState(printer));
    }

    @Override
    public void extractJammingPaper() {
    }

    @Override
    public void refillCartridge() {
        printer.setPaintPercentage(100);
        if (isPrintingAvailable())
            printer.changeState(new WaitingState(printer));
    }

    private boolean isPrintingAvailable() {
        return printer.getPaintPercentage() > 0
                && printer.getPagesCount() > 0;
    }
}
