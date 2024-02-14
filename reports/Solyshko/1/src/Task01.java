import java.util.ArrayList;
import java.util.Random;

public class Task01 {
    public static void main(String[] args) {
        ArrayList<Integer> array = new ArrayList<>();
        for(String itr : args)
        {
            array.add(Integer.parseInt(itr));
        }
        Random rnd = new Random();
        int firstLengthOfArray = array.size();
        for(int i = 0; i < firstLengthOfArray; i++)
        {
            int index = rnd.nextInt(array.size());
            System.out.print(array.get(index) + " ");
            array.remove(index);
        }
    }
}
