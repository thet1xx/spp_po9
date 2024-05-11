package org.example.task03;

public class TextPrinter implements Printer {
    @Override
    public PrintResult createPrintFile() {
        return new TextFile();
    }
}
