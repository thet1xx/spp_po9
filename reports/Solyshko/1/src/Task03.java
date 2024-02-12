import java.util.Scanner;

public class Task03 {
    // Task3
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите строку для абривиатуры: ");
        String str = scanner.nextLine();
        String abbreviate_str = abbreviate(str);
        System.out.println(abbreviate_str);
    }

    static String abbreviate(String str){
        String newStr = "";
        newStr += str.charAt(0);
        for(int i = 0; i < str.length(); i++)
        {
            if(str.charAt(i) == ' ' && (i+1) < str.length())
            {
                newStr += str.charAt(i+1);
            }
        }

        return newStr.toUpperCase();
    }
}


