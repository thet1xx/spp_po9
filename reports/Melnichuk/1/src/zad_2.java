import java.util.Arrays;
import java.util.Scanner;

public class zad_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Длина массива:");
        int length = scanner.nextInt();
        double[] array = new double[length];
        System.out.println("Значения:");
        for(int i = 0; i < length; i++){
            array[i] = scanner.nextDouble();
        }
        System.out.println("Начальное значение:");
        int st = scanner.nextInt();
        System.out.println("Конечное:");
        int end = scanner.nextInt();
        System.out.println(Arrays.toString(zad_2.subarray(array, st, end)));

    }
    public static double[] subarray(double[] array, int startIndex,int endIndex){

        double[] karray = new double[endIndex - startIndex];
        for(int i = 0, j = startIndex; j < endIndex; i++, j++){
            karray[i] = array[j];
        }
        return karray;
    }

}
