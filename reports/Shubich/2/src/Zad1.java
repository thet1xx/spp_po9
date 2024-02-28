import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Zad1 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader("file.txt"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        String line;
        Set<String> wordsSet = new TreeSet<>();
        while ((line = reader.readLine()) != null) {
            line = line.toLowerCase(Locale.ROOT);
            wordsSet.addAll(Arrays.asList(line.split("[\\p{Punct}\\s]+")));
        }
        reader.close();
        for (String s:wordsSet){
                System.out.print(s + " ");
        }

    }
}