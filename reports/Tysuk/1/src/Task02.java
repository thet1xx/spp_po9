import java.util.Scanner;
public class Task02 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите размер массива: ");
        int size = scanner.nextInt();
        double[] array = new double[size];

        System.out.println("Введите элементы массива:");
        for (int i = 0; i < size; i++) {
            array[i] = scanner.nextDouble();
        }

        System.out.print("Введите количество позиций для сдвига влево: ");
        int shift = scanner.nextInt();

        shiftLeft(array, shift);

        System.out.println("Массив после сдвига:");
        for (double element : array) {
            System.out.print(element + " ");
        }
    }

    public static void shiftLeft(double[] array, int shift) {
        int n = array.length;
        shift %= n; // если shift больше длины массива, оставляем только сдвиг по модулю

        for (int i = 0; i < shift; i++) {
            double temp = array[0];
            for (int j = 0; j < n - 1; j++) {
                array[j] = array[j + 1];
            }
            array[n - 1] = temp;
        }
    }
}
