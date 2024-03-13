import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        int count = 10;
        String path;
        File file = new File("");
        if(args.length == 3) {
            if(args[0]!="-n"){
                System.out.println("Неверный 1-ый аргумент (должен быть -n)");
                return;
            }
            if(!isNumeric(args[1])){
                System.out.println("Неверный 2-ый аргумент (должен быть числом)");
                return;
            }
            count = Integer.getInteger(args[1]);
            path = args[2];
            file = new File(path);
            if(!file.canRead()){
                System.out.println("Файл по пути нечитаем");
                return;
            }
        }

        if(args.length == 2) {
            if(!isNumeric(args[0])){
                System.out.println("Неверный 1-ый аргумент (должен быть числом)");
                return;
            }
            System.out.println(args[0]);
            count = Integer.parseInt(args[0]);
            path = args[1];
            file = new File(path);
            if(!file.canRead()){
                System.out.println("Файл по пути нечитаем");
                return;
            }
        }
        if(args.length != 2 && args.length != 3) {
            System.out.println("Неверное число аргументов");
            return;
        }


        Scanner scan = new Scanner(file);
        for(int i=0;i<count;i++){
            if(scan.hasNext())
            {
                System.out.println(scan.nextLine());
            }
            else break;
        }
    }

    public static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }
}