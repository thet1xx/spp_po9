import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        int rows, cols;
        Scanner input = new Scanner(System.in);

        try {
            System.out.print("Введите количество строк матрицы: ");
            rows = input.nextInt();
            System.out.print("Введите количество столбцов матрицы: ");
            cols = input.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Ошибка ввода: необходимо ввести целое число.");
            return;
        }

        double[][] matrix = new double[rows][cols];

        System.out.println("Введите элементы матрицы: ");
        try {
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    matrix[i][j] = input.nextDouble();
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("Ошибка ввода: необходимо вводить числа в формате %,%.");
            return;
        }
        input.close();

        randomPertrubations(matrix);

        System.out.println("Перемешанная матрица: ");
        for (double[] doubles : matrix) {
            for (double j : doubles) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    static void randomPertrubations(double[][] matrix) {
        Random rndRow = new Random();
        Random rndCol = new Random();
        for (int i = matrix.length - 1; i >= 0; i--) {
            for (int j = matrix[i].length - 1; j >= 0; j--) {
                int row = rndRow.nextInt(i + 1);
                int col = rndCol.nextInt(j + 1);
                double temp = matrix[row][col];
                matrix[row][col] = matrix[i][j];
                matrix[i][j] = temp;
            }
        }
    }
}
