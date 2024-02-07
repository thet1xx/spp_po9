import java.util.Arrays;

public class Main3 {
    public static String repeat(char ch, int repeat){
        return String.valueOf(ch).repeat(Math.max(0, repeat));
    }

    public static void main(String[] args) {
        System.out.println("Test1: " + repeat('e', -4));
        System.out.println("Test2: " + repeat('e', 0));
        System.out.println("Test3: " + repeat('e', 5));
    }
}
