package Lab2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Lab2_1 {
    private static String filePath = "src/file.txt";
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File(filePath);
        Scanner scanner = new Scanner(file);
        ArrayList<String> lines = new ArrayList<>();
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            lines.add(line);
        }
        ArrayList<Integer> indexes = new ArrayList<>();
        for (int i = 0; i < lines.size(); i++){
            for (char c : lines.get(i).toCharArray()){
                if (Character.isDigit(c)){
                    indexes.add(i);
                }
            }
        }
        System.out.println(lines.get(indexes.get(indexes.size()/2)));
    }
}
