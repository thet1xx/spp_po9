package Task3;

import Task3.States.WaitingState;

/*
TODO
    State
    Проект «Принтер». Предусмотреть выполнение операций (печать, загрузка бумаги, извлечение
    зажатой бумаги, заправка картриджа), режимы – ожидание, печать документа, зажатие бумаги,
    отказ – при отсутствии бумаги или краски, атрибуты – модель, количество листов в лотке,
    % краски в картридже, вероятность зажатия.
 */
public class Printer implements PrinterFunctions{
    private String model;
    private int pagesCount;
    private double paintPercentage; // [0..100]
    private double jammingProbability; // [0..100]
    private State state;

    public Printer(String model, int pagesCount, double paintPercentage, double jammingProbability) {
        this.model = model;
        this.pagesCount = pagesCount;
        this.paintPercentage = paintPercentage;
        this.jammingProbability = jammingProbability;
        state = new WaitingState(this);
    }

    public void changeState(State state){
        this.state = state;
    }

    public String getModel() {
        return model;
    }

    public int getPagesCount() {
        return pagesCount;
    }

    public void setPagesCount(int pagesCount) {
        this.pagesCount = pagesCount;
    }

    public double getPaintPercentage() {
        return paintPercentage;
    }

    public void setPaintPercentage(double paintPercentage) {
        this.paintPercentage = paintPercentage;
    }

    public double getJammingProbability() {
        return jammingProbability;
    }

    @Override
    public void print(int numPaper) {
        state.print(numPaper);
    }

    @Override
    public void loadPaper(int numPaper) {
        state.loadPaper(numPaper);
    }

    @Override
    public void extractJammingPaper() {
        state.extractJammingPaper();
    }

    @Override
    public void refillCartridge() {
        state.refillCartridge();
    }

    @Override
    public String toString() {
        return "Printer{" +
                "model='" + model + '\'' +
                ", pagesCount=" + pagesCount +
                ", paintPercentage=" + paintPercentage +
                ", state=" + state +
                '}';
    }
}
