package task;

import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.printf("3 задание\n");
        Scanner snaper = new Scanner(System.in);
        System.out.printf("введите строку\n");
        String str_for_template;
        str_for_template = new java.util.Scanner(System.in).next();
        if(pangramEng(str_for_template))
            System.out.printf("панграмма\n");
        else
            System.out.printf("не панграмма\n");

        System.out.printf("2 задание\n");
        double[] arr = {1,2,3,4};
        System.out.printf("ДО\n");
        for(int i=0;i<arr.length;i++){
            System.out.printf(arr[i] + "\n");
        }
        shiftRight(arr, 2);
        System.out.printf("ПОСЛЕ\n");
        for(int i=0;i<arr.length;i++){
            System.out.printf(arr[i] + "\n");
        }

        System.out.printf("1 задание\n");
        lab_1_1 govno = null;
        govno.main();

    }
    public static void shiftRight(double[] array, int shift){
        for(int i=0;i<shift;i++){
            double temp=array[array.length-1];
            for(int j=array.length-1;j>0;j--){
                array[j]=array[j-1];
            }
            array[0]=temp;
        }
    }
    static public boolean pangramEng(String str){
        String alphabet1 = "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ";
        String alphabet2 = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";
        boolean[] mask = new boolean[alphabet1.length()];
        for(int i=0;i<str.length();i++){
            for(int j=0;j<alphabet1.length();j++){
                if(str.charAt(i) == alphabet1.charAt(j) || str.charAt(i) == alphabet2.charAt(j))
                    mask[j] = true;
            }
        }
        for(int j=0;j<alphabet1.length();j++){
            if(!mask[j])
                return false;
        }
        return true;
    }
}