package task;
import javax.swing.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class lab_1_1{
    public static void main() throws IOException {
        Scanner snaper = new Scanner(System.in);
        System.out.printf("введи колво чисел\n");
        int count;
        kolvo = new java.util.Scanner(System.in).nextInt();
        int numer;
        int[] numers = new int[count];
        System.out.printf("введи еще " + count + " чисел\n");
        Map<Integer, Integer> table = new HashMap<>();
        for (int i = 0; i < count; i++) {
            numers[i] = snaper.nextInt();
            if(table.containsKey(numers[i])){
                table.put(numers[i], table.get(numers[i])+1);
            }
            else{
                table.put(numers[i],1);
            }
        }
        int max=-32000;
        Iterator<Map.Entry<Integer, Integer>> itr = table.entrySet().iterator();
        while(itr.hasNext()) {
            Map.Entry<Integer, Integer> entry =  itr.next();
            Integer key = entry.getKey();
            Integer value = entry.getValue();
            if(value>max){
                max = value;
            }
        }
        itr = table.entrySet().iterator();
        while(itr.hasNext()) {
            Map.Entry<Integer, Integer> entry =  itr.next();
            Integer key = entry.getKey();
            Integer value = entry.getValue();
            if(value==max){
                System.out.printf("это мода " + key + "\n");
            }
        }
    }
}
