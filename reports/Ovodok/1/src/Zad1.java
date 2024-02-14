import java.util.Arrays;

public class Zad1 {
    public static void main(String[] args){
        int N = args.length;
        int[] numSequence = new int[N];
        for (int i = 0; i < N; i++) {
            numSequence[i] = Integer.parseInt(args[i]);
            System.out.print(numSequence[i] + " ");
        }
        System.out.println("|");
        Arrays.sort(numSequence);
        for (int number : numSequence){
            System.out.print(number + " ");
        }
        System.out.println("|");
        System.out.println("Difference = " + (numSequence[N - 1] - numSequence[0]));
    }
}
