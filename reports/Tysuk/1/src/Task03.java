import java.util.Scanner;

public class Task03 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите первую строку: ");
        String str1 = scanner.nextLine();
        System.out.print("Введите вторую строку: ");
        String str2 = scanner.nextLine();

        String result = xor(str1, str2);
        System.out.println("Результат операции XOR: " + result);
    }

    public static String xor(String str1, String str2) {
        if (str1.length() != str2.length()) {
            throw new IllegalArgumentException("Длины строк должны быть одинаковыми");
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str1.length(); i++) {
            //  XOR
            int xorResult = str1.charAt(i) ^ str2.charAt(i);
            // Преобразуем результат XOR обратно в символ и добавляем к результату
            sb.append((char) xorResult);
        }
        return sb.toString();
    }
}
