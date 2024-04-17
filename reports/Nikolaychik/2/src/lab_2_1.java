import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner snaper = new Scanner(System.in);
        System.out.printf("введите путь\n");
        String path;
        path = new Scanner(System.in).next();
        File my_file = new File(path);
        if(!my_file.exists()){
            System.out.printf("объект не существует\n");
            return;
        }
        if(!my_file.isFile()){
            System.out.printf("объект не файл\n");
            return;
        }
        if(!my_file.canRead()){
            System.out.printf("файл нечитаем\n");
            return;
        }
        Map<String, Vector<Integer>> words = new HashMap<>();
        try(Scanner fin=new Scanner(new FileInputStream(path)))
        {
            String str = new String();
            int str_num=1;
            while(fin.hasNext()){
                str = fin.nextLine();
                str = str.replaceAll("[^a-zA-Zа-яА-ЯёЁ]+", " ");
                    String[] temp = str.split("\\s+");
                    for (int j = 0; j < temp.length; j++) {
                        temp[j] = temp[j].toUpperCase();
                        if (words.containsKey(temp[j])) {
                            Vector<Integer> veco = words.get(temp[j]);
                            veco.add(str_num);
                            words.put(temp[j], veco);
                        } else {
                            Vector<Integer> veco = new Vector<Integer>();
                            veco.add(str_num);
                            words.put(temp[j], veco);
                        }
                    }
                    str = new String();
                    str_num++;
            }
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
        Iterator<Map.Entry<String, Vector<Integer>>> itr = words.entrySet().iterator();
        while(itr.hasNext()) {
            Map.Entry<String, Vector<Integer>> entry =  itr.next();
            String key = entry.getKey();
            Vector<Integer> value = entry.getValue();
            System.out.printf(key + ":\n");
            for(int i=0;i<value.size();i++)
            {
                System.out.printf(value.get(i) + " ");
            }
            System.out.printf("\n");
        }
    }
}
