package org.example.task03;

public interface Printer {
    default void print() {
        System.out.println("Printing...");
        // ...
        System.out.println("Done: " + createPrintFile());
    }

    PrintResult createPrintFile();
}
