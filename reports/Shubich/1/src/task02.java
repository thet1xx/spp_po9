public class task02 {
    public static void main(String[] args) {
        int size = 10;
        double[][] matrix = single(size);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
    static double[][] single(int size) {
        double[][] matrix = new double[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j ++) {
                if (j == i) {
                    matrix[i][j] = 1.0;
                } else {
                    matrix[i][j] = 0.0;
                }
            }
        }
        return matrix;
    }
}
