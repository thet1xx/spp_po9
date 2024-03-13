import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        example_1();
        System.out.println("\n\n\n\n");
        example_2();



    }
    public static void example_1(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("Введите длину катетов");
        double catet_a = scanner.nextDouble();
        double catet_b = scanner.nextDouble();
        System.out.println("Конструктор по-умолчанию");
        new Triangle().output();
        System.out.println("Конструктор по-умолчанию");
        Triangle a =new Triangle(catet_a,catet_b);
        a.output();
        System.out.println("Конструктор по-умолчанию");
        new Triangle(a).output();
    }
    public static void example_2(){
        Autopark Das_Auto = new Autopark();
        Das_Auto.out_InPark();
        System.out.println("Many KM");
        Autopark.out(Das_Auto.allBusManyKm());
        System.out.println("OLD");
        Autopark.out(Das_Auto.allBusOld());
        System.out.println("ON ROUTE 1");
        Autopark.out(Das_Auto.allBusOnRoute(1));

    }
}