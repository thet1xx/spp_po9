package Task3;

public class PrinterTest {
    public static void main(String[] args) {
        Printer printer = new Printer("HP", 5, 100, 10);
        System.out.println("New printer:");
        System.out.println(printer);

        System.out.println("\nPrinted 8 papers:");
        printer.print(8);
        System.out.println(printer);

        System.out.println("\nLoaded 10 papers:");
        printer.loadPaper(10);
        System.out.println(printer);

        System.out.println("\nPrinted 5 papers:");
        printer.print(5);
        System.out.println(printer);
    }
}
