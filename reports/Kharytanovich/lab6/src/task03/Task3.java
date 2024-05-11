package org.example.task03;

public class Task3 {
    public static void main(String[] args) {
        Printer printer = new TextPrinter();
        printer.print();

        printer = new PhotoPrinter();
        printer.print();
    }
}