import java.util.Scanner;

public class zad_3 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите строку:");
        String line = scanner.nextLine();
        System.out.println("На сколько сместить:");
        int shift = scanner.nextInt();
        System.out.println(zad_3.shiftRight(line, shift));

    }
    public static String shiftRight(String srt, int shift){
        int cursor;
        if(shift < 0){
            cursor = -shift;
        }else if(shift > srt.length()){
            shift %= srt.length();
            cursor = srt.length() - shift;
        }else{
            cursor = srt.length() - shift;
        }
        return srt.substring(cursor) + srt.substring(0, cursor);
    }
}
