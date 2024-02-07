import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        for (String elem : args){
            arr.add(Integer.valueOf(elem));
        }
        arr.sort(null);
        if (arr.size() % 2 == 0){
            System.out.println((arr.get(arr.size() / 2) + arr.get(arr.size() / 2 - 1)) / 2.f);
        } else {
            System.out.println(arr.get(arr.size() / 2));
        }
    }
}
