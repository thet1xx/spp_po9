import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        example_1();
        System.out.println("\n\n\n\n");
        try {
            example_2();
        } catch (FileNotFoundException e) {
            System.out.println("Файла нетутутутутуту");
            return;
        }

    }
    public static void example_1(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("Введите длину катетов");
        double catet_a = scanner.nextDouble();
        double catet_b = scanner.nextDouble();
        System.out.println("Конструктор по-умолчанию");
        new Triangle().output();
        System.out.println("Конструктор с параметрами");
        Triangle a =new Triangle(catet_a,catet_b);
        a.output();
        System.out.println("Конструктор копирования");
        new Triangle(a).output();
    }
    public static void example_2() throws FileNotFoundException {
        Autopark Das_Auto = new Autopark();
        Scanner sc = new Scanner(new FileInputStream("D:\\govno\\lab_3_1_spp\\src\\notes.txt"));
        while(sc.hasNext()){
            String q = sc.nextLine();
            String w = sc.nextLine();
            String e = sc.nextLine();
            String r = sc.nextLine();
            String t = sc.nextLine();

            Das_Auto.AddBus(Integer.parseInt(q),
                    Integer.parseInt(w),
                    e,
                    Integer.parseInt(r),
                    Long.parseLong(t));
        }
        Das_Auto.out_InPark();
        System.out.println("Many KM\n");
        Autopark.out(Das_Auto.allBusManyKm());
        System.out.println("OLD\n");
        Autopark.out(Das_Auto.allBusOld());
        System.out.println("ON ROUTE 1\n");
        Autopark.out(Das_Auto.allBusOnRoute(1));

    }
}