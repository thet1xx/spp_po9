import java.util.Random;
import java.util.Scanner;

public class Task2 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Введите количество строк: ");
        int rows = input.nextInt();
        System.out.print("Введите количество столбцов: ");
        int cols = input.nextInt();

        if (cols == 0 || rows == 0)
            System.out.println("Ошибка! Такой матрицы не существует");
        else if (rows != cols)
            System.out.println("Ошибка! В матрице количество строк и столбцов должно совпадать");
        else {
            double[][] matrix = new double[rows][cols];

            System.out.println("Введите элементы матрицы:");

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    matrix[i][j] = input.nextDouble();
                }
            }

            System.out.println("Исходная матрица:");
            printMatrix(matrix);

            randomPerturbations(matrix);

            System.out.println("Матрица после случайных перестановок:");
            printMatrix(matrix);
        }
    }

    public static void randomPerturbations(double[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        Random random = new Random();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int randomRow = random.nextInt(rows);
                int randomCol = random.nextInt(cols);

                double temp = matrix[i][j];
                matrix[i][j] = matrix[randomRow][randomCol];
                matrix[randomRow][randomCol] = temp;
            }
        }
    }

    public static void printMatrix(double[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}