import java.util.Scanner;

public class Task1 {

    public static void main(String[] arg) {

        Scanner input = new Scanner(System.in);

        System.out.print("Введите количество элементов: ");
        int count = input.nextInt();

        int[] arr = new int[count];
        for (int i = 0; i < count; i++) {
            System.out.print("Элемент " + i + ": ");
            arr[i] = input.nextInt();
        }

        getUniqueNumbers(arr);
    }

    public static void getUniqueNumbers(int[] arr) {

        int[] isUnique = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[i] == arr[j])
                    isUnique[i]++;
            }
        }

        System.out.print("Уникальные числа: ");

        for (int i = 0; i < arr.length; i++) {
            if (isUnique[i] == 1)
                System.out.print(arr[i] + " ");
        }
    }
}
