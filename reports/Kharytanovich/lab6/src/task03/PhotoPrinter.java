package org.example.task03;

public class PhotoPrinter implements Printer {
    @Override
    public PrintResult createPrintFile() {
        return new PhotoFile();
    }
}
