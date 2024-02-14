import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Введите строку: ");
        String inputString = input.nextLine();
        System.out.println("isAllLowerCase(\"" + inputString + "\") = " + isAllLowerCase(inputString));
    }

    public static boolean isAllLowerCase(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }

        int i = 0;
        while (i < str.length()) {
            char c = str.charAt(i);
            if (!Character.isLowerCase(c))
                return false;
            i++;
        }

        return true;
    }
}