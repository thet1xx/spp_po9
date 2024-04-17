import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class task01 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Path to file:");
        String path = in.nextLine();
        HashSet<String> words = new HashSet<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] lineWords = line.split(" ");
                words.addAll(Arrays.asList(lineWords));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        for (String word : words) {
            System.out.println(word);
        }
    }
}
