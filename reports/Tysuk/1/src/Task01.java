import java.util.Scanner;

public class Task01 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(args[0]);

        int[] numbers = new int[n];

        System.out.println("Введите " + n + " целых чисел:");
        for (int i = 1; i < n; i++) {
            numbers[i] = Integer.parseInt(args[i]);
        }

        int[] counts = new int[10];

        for (int number : numbers) {
            int length = String.valueOf(number).length();
            if (length <= 9) {
                counts[length - 1]++;
            }
        }

        for (int i = 0; i < counts.length; i++) {
            if (counts[i] > 0) {
                System.out.println("Количество " + (i + 1) + "-значных чисел: " + counts[i]);
            }
        }
    }
}

