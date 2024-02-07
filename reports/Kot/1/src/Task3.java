import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        String stringToCheck = "";
        while (!stringToCheck.equals("exit")) {
            Scanner input = new Scanner(System.in);
            System.out.print("Введите строку (exit для завершения): ");
            stringToCheck = input.nextLine();
            System.out.println(isAllLowerCase(stringToCheck));
        }
    }

    static boolean isAllLowerCase(String cs) {
        if (cs != null && !cs.isEmpty()) {
            for (int i = 0; i < cs.length(); i++) {
                char ch = cs.charAt(i);
                if (!Character.isLowerCase(ch)) return false;
            }
            return true;
        }
        return false;
    }
}
