import java.util.Scanner;

public class Task02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите количество строк: ");
        int rows = scanner.nextInt();

        System.out.println("Введите количество столбцов: ");
        int columns = scanner.nextInt();

        System.out.println("Введите значения матрицы: ");

        double[][] matrix = new double[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = scanner.nextDouble();
            }
        }

        double[][] newMatrix;
        newMatrix = transpose(matrix);
        for (int i = 0; i < newMatrix.length; i++) {
            System.out.print("| ");
            for (int j = 0; j < newMatrix[0].length; j++) {
                System.out.print(newMatrix[i][j] + " ");
            }
            System.out.print("|");
            System.out.println();
        }

    }

    public static double[][] transpose(double[][] matrix) {
        double[][] newMatrix = new double[matrix[0].length][matrix.length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                newMatrix[j][i] = matrix[i][j];
            }
        }

        return newMatrix;
    }
}
