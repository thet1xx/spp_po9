import java.util.Scanner;

public class Task01 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите количество чисел N: ");
        int n = scanner.nextInt();

        int[] numbers = new int[n];

        System.out.println("Введите " + n + " целых чисел:");
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
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
