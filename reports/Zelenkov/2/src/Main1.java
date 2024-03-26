import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Main1 {
    public static void main(String[] args) throws IOException {
        List<String> lines1, lines2;

        lines1 = Files.readAllLines(Paths.get("C:\\Users\\kosty\\IdeaProjects\\Lab2\\src\\file1.txt"));
        lines2 = Files.readAllLines(Paths.get("C:\\Users\\kosty\\IdeaProjects\\Lab2\\src\\file2.txt"));
        if(lines1.equals(lines2)){
            System.out.println("Текстовые файлы идентичны");
        } else {
            for (int i = 0; i < lines1.size(); i++) {
                if(!lines1.get(i).equals(lines2.get(i))){
                    for (int j = 0; j < lines1.get(i).length(); j++) {
                        if(lines1.get(i).charAt(j) != lines2.get(i).charAt(j)){
                            System.out.println("Строка не совпадает.\nСимвол: " + "[" + lines1.get(i).charAt(j) + "]" +
                                    "\n" + "Позиция: "+ (j+1) + "\nСтрока 1: " + lines1.get(i) + "\nСтрока 2: " + lines2.get(i));
                            return;
                        }
                    }
                }
            }
        }
    }
}
