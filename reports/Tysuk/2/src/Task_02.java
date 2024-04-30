import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Task_02 {

    public static void main(String[] args) {
        if (args.length < 3) {
            System.err.println("Использование: join [-1 номер_поля] [-2 номер_поля] файл1 файл2 файл3");
            return;
        }

        int field1 = 1;
        int field2 = 1;
        String file1 = null;
        String file2 = null;
        String file3 = null;

        int i = 0;
        try {
            while (i < args.length) {
                if (args[i].equals("-1")) {
                    field1 = Integer.parseInt(args[i + 1]);
                    i += 2;
                } else if (args[i].equals("-2")) {
                    field2 = Integer.parseInt(args[i + 1]);
                    i += 2;
                } else if (file1 == null) {
                    file1 = args[i];
                    i++;
                } else if (file2 == null) {
                    file2 = args[i];
                    i++;
                } else {
                    file3 = args[i];
                    i++;
                }
            }
        } catch (NumberFormatException e) {
            System.err.println("Ошибка: номер поля должен быть целым числом.");
            return;
        }

        if (file1 == null || file2 == null || file3 == null) {
            System.err.println("Ошибка: не указаны все входные файлы.");
            return;
        }

        try (BufferedReader reader1 = new BufferedReader(new FileReader(file1));
             BufferedReader reader2 = new BufferedReader(new FileReader(file2));
             BufferedWriter writer = new BufferedWriter(new FileWriter(file3))) {

            Map<String, String> map = new HashMap<>();

            String line;
            while ((line = reader1.readLine()) != null) {
                String[] parts = line.split("\\s+", Math.max(field1, 2));
                if (parts.length >= field1) {
                    map.put(parts[field1 - 1], line);
                }
            }

            while ((line = reader2.readLine()) != null) {
                String[] parts = line.split("\\s+", Math.max(field2, 2));
                if (parts.length >= field2 && map.containsKey(parts[field2 - 1])) {
                    String resultLine = map.get(parts[field2 - 1]) + " " + line;
                    writer.write(resultLine);
                    writer.newLine();
                }
            }
        } catch (IOException e) {
            System.err.println("Ошибка при чтении/записи файла: " + e.getMessage());
        }
    }
}
