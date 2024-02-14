import java.util.Arrays;

public class Zad2 {

    public static void main(String[] args){
        int N = args.length;
        long[] numSequence = new long[N];
        for (int i = 0; i < N; i++) {
            numSequence[i] = Long.parseLong(args[i]);
            System.out.print(numSequence[i] + " ");
        }
        long element = 890;
        System.out.println("remove " + element);
        System.out.println(Arrays.toString(removeElement(numSequence, element)));
    }

    static long[] removeElement(long[] array, long element){
        int N = array.length;
        for (int i = 0; i < N; i++) {
            if(array[i] == element){
                long[] newArray = new long[N - 1];
                for (int j = 0; j < i ; j++) {
                    newArray[j] = array[j];
                }
                for (int j = i; j < N-1 ; j++) {
                    newArray[j] = array[j + 1];
                }
                return newArray;
            }
        }
        System.out.println(element + " Does not exist");
        return array;
    }
}
