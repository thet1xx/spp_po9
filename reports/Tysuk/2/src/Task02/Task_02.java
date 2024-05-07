import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Task_02 {

    public static void main(String[] args) {
        if (args.length < 2) {
            System.err.println("Использование: java Task_02 файл1 файл2");
            return;
        }

        String file1 = args[0];
        String file2 = args[1];

        try (BufferedReader reader1 = new BufferedReader(new FileReader(file1));
             BufferedReader reader2 = new BufferedReader(new FileReader(file2));
             BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"))) {

            Map<String, String> map = new HashMap<>();

            String line;
            while ((line = reader2.readLine()) != null) {
                String[] parts = line.split("\\s+", 2);
                if (parts.length >= 2) {
                    map.put(parts[0], parts[1]);
                }
            }

            while ((line = reader1.readLine()) != null) {
                String[] parts = line.split("\\s+", 2);
                if (parts.length >= 2 && map.containsKey(parts[0])) {
                    String resultLine = parts[0] + " " + parts[1] + " " + map.get(parts[0]);
                    writer.write(resultLine);
                    writer.newLine();
                }
            }
        } catch (IOException e) {
            System.err.println("Ошибка при чтении/записи файла: " + e.getMessage());
        }
    }
}
