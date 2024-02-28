import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Task01 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите путь первого файла: ");
        String file1Path = scanner.nextLine();

        System.out.print("Введите путь второго файла: ");
        String file2Path = scanner.nextLine();

        try {
            if (areFilesEqual(file1Path, file2Path)) {
                System.out.println("Файлы эквивалентны");
            } else {
                System.out.println("Файлы отличаются:");
                printFirstDifference(file1Path, file2Path);
            }
        } catch (IOException e) {
            System.err.println("Ошибка при чтении файлов: " + e.getMessage());
        }
    }

    private static boolean areFilesEqual(String file1Path, String file2Path) throws IOException {
        try (BufferedReader reader1 = new BufferedReader(new FileReader(file1Path));
             BufferedReader reader2 = new BufferedReader(new FileReader(file2Path))) {

            String line1, line2;
            while ((line1 = reader1.readLine()) != null && (line2 = reader2.readLine()) != null) {
                if (!line1.equals(line2)) {
                    return false;
                }
            }

            return reader1.readLine() == null && reader2.readLine() == null;
        }
    }

    private static void printFirstDifference(String file1Path, String file2Path) throws IOException {
        try (BufferedReader reader1 = new BufferedReader(new FileReader(file1Path));
             BufferedReader reader2 = new BufferedReader(new FileReader(file2Path))) {

            int lineNumber = 1;
            int position = 0;

            String line1, line2;
            while ((line1 = reader1.readLine()) != null && (line2 = reader2.readLine()) != null) {
                if (!line1.equals(line2)) {
                    position = findFirstDifferencePosition(line1, line2);
                    break;
                }
                lineNumber++;
            }

            System.out.println("Первая различающаяся строка: " + lineNumber);
            System.out.println("Позиция различия символов: " + position);
        }
    }

    private static int findFirstDifferencePosition(String str1, String str2) {
        int position = 0;
        while (position < str1.length() && position < str2.length() && str1.charAt(position) == str2.charAt(position)) {
            position++;
        }
        return position + 1;
    }
}
