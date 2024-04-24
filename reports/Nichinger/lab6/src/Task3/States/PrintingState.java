package Task3.States;

import Task3.Printer;
import Task3.State;

public class PrintingState extends State {
    private final double paintConsumption = 5;
    public PrintingState(Printer printer) {
        super(printer);
        stateName = "PrintingState";
    }

    @Override
    public void print(int numPaper) {
        for (int i = 0; i < numPaper; i++){
            if (isPrintingAvailable()){
                double randValue = Math.random() * 100;
                if (randValue <= printer.getJammingProbability()){
                    printer.changeState(new JammingState(printer));
                    return;
                }

                printer.setPagesCount(printer.getPagesCount() - 1);
                printer.setPaintPercentage(printer.getPaintPercentage() - paintConsumption);
            }
            else {
                printer.changeState(new FailureState(printer));
                return;
            }
        }
        printer.changeState(new WaitingState(printer));
    }

    @Override
    public void loadPaper(int numPaper) {
    }

    @Override
    public void extractJammingPaper() {
    }

    @Override
    public void refillCartridge() {
    }

    private boolean isPrintingAvailable() {
        return printer.getPaintPercentage() - paintConsumption >= 0
                && printer.getPagesCount() - 1 >= 0;
    }
}
