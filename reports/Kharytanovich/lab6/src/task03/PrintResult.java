package org.example.task03;

public abstract class PrintResult {
    protected String printType;

    @Override
    public String toString() {
        return "PrintResult{" +
                "printType='" + printType + '\'' +
                '}';
    }
}
