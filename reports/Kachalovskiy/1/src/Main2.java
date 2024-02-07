import java.util.ArrayList;
import java.util.Arrays;

public class Main2 {
    public static double[] add(double[] array, int index, double element){
        double[] newArray = new double[array.length+1];
        for (int i = 0; i < index; i++){
            newArray[i] = array[i];
        }
        newArray[index] = element;
        for (int i = index; i < array.length; i++){
            newArray[i+1] = array[i];
        }
        return newArray;
    }
    public static void main(String[] args) {
        double[] array = {1, 2, 3, 4};
        System.out.println(Arrays.toString(add(array, 2, 100)));
    }
}
