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
        int kolvo;
        kolvo = new java.util.Scanner(System.in).nextInt();
        int chislo;
        int[] chisla = new int[kolvo];
        System.out.printf("введи еще " + kolvo + " чисел\n");
        Map<Integer, Integer> tablycya = new HashMap<>();
        for (int i = 0; i < kolvo; i++) {
            chisla[i] = snaper.nextInt();
            if(tablycya.containsKey(chisla[i])){
                tablycya.put(chisla[i], tablycya.get(chisla[i])+1);
            }
            else{
                tablycya.put(chisla[i],1);
            }
        }
        int max=-32000;
        Iterator<Map.Entry<Integer, Integer>> itr = tablycya.entrySet().iterator();
        while(itr.hasNext()) {
            Map.Entry<Integer, Integer> entry =  itr.next();
            Integer key = entry.getKey();
            Integer value = entry.getValue();
            if(value>max){
                max = value;
            }
        }
        itr = tablycya.entrySet().iterator();
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
