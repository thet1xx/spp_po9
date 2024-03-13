import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class task02 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        if (args.length == 0 || !args[0].equals("cat")) {
            System.out.println("Usage: cat [file1] [file2] ...");
            return;
        }
        ArrayList <String> files = new ArrayList<>();
        StringBuilder line = new StringBuilder();
        boolean writeFile = false;
        try {
            for (int i = 1, j = 0; i < args.length; i++) {
                String fileName = args[i];
                if (fileName.equals("-")) {
                    line.append(readFromStdin()).append("\n");
                }
                if (fileName.equals(">")){
                    writeFile = true;
                    continue;
                }
                if (fileName.contains(".txt")){
                    files.add(fileName);
                }
            }
            if(writeFile){
                PrintWriter writer = new PrintWriter(new FileWriter(files.get(files.size() - 1), true));
                writer.write(line.toString());
                for(int i = 0; i < files.size() - 1; i++){
                    String content = readFromFile(files.get(i));
                    writer.write(content);
                }
                writer.close();
            } else{
                System.out.println(line);
                for (String file : files) {
                    BufferedReader fin = new BufferedReader(new FileReader(file));
                    while ((line = new StringBuilder(fin.readLine())) != null) System.out.println(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String readFromFile(String fileName) throws IOException {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
        }
        return content.toString();
    }

    private static String readFromStdin() throws IOException {
        Scanner in = new Scanner(System.in);
        return in.nextLine();
    }
}
