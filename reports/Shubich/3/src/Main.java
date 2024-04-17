package org.example;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        Zad1 traingle = new Zad1(4, 4 , 3.23);
        System.out.println("Является ли треугольником: " + traingle.isIsoscelesTraingle());
        System.out.println("Площадь: " + traingle.area());
        System.out.println("Периметр: " + traingle.perimeter());

        System.out.println();

        Zad1 traingle1 = new Zad1(4, 4 , 3.23);
        System.out.println("Равны ли треугольник1 и треугольник2: " + traingle1.equals(traingle));

        System.out.println();

        traingle1.setA(10);
        traingle1.setB(8);
        traingle1.setC(6);
        System.out.println("Является ли треугольником: " + traingle1.isIsoscelesTraingle());
        System.out.println("Площадь: " + traingle1.area());
        System.out.println("Периметр: " + traingle1.perimeter());

        System.out.println();

        Zad1 traingle2 = new Zad1(6, 15 , 15);
        System.out.println("Является ли треугольником: " + traingle2.isIsoscelesTraingle());
        System.out.println("Площадь: " + traingle2.area());
        System.out.println("Периметр: " + traingle2.perimeter());

        System.out.println();


        Zad2 calculator = new Zad2();

        if (args.length > 0) {
            // Если передан аргумент командной строки - имя файла с командами
            String fileName = args[0];
            try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    calculator.executeCommand(line);
                }
            } catch (IOException e) {
                System.out.println("\nОшибка при чтении файла: " + e.getMessage() );
            }
        } else {
//
            // Чтение команд из файла
            try (BufferedReader reader = new BufferedReader(new FileReader("/Users/dashubaa/univer/3kurs/spp/lab3/lab3/src/main/java/org/example/command.txt"))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    calculator.executeCommand(line);
                }
            } catch (IOException e) {
                System.out.println("\nОшибка при чтении файла: " + e.getMessage());
            }
        }
    }
}