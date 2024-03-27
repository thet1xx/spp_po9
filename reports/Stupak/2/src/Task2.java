

import java.io.*;
import java.util.*;

public class Task2 {
    public static void main(String[] args) throws Exception {

        boolean count = false;
        boolean duplicates = false;
        boolean unique = false;
        boolean ignoreCase = false;
        String inputFile = null;
        String outputFile = null;

        for (int i = 1; i < args.length; i++) {
            switch (args[i]) {
                case "-c":
                    count = true;
                    break;
                case "-d":
                    duplicates = true;
                    break;
                case "-u":
                    unique = true;
                    break;
                case "-i":
                    ignoreCase = true;
                    break;
                default:
                    if (inputFile == null) {
                        inputFile = args[i];
                    } else if (outputFile == null) {
                        outputFile = args[i];
                    }
                    break;
            }
        }

        try {
            BufferedReader reader;
            PrintWriter writer;

            if (inputFile != null) {
                reader = new BufferedReader(new FileReader(inputFile));
            } else {
                reader = new BufferedReader(new InputStreamReader(System.in));
            }

            if (outputFile != null) {
                writer = new PrintWriter(outputFile);
            } else {
                writer = new PrintWriter(System.out);
            }

            Map<String, Integer> countMap = new HashMap<>();

            String line;
            while ((line = reader.readLine()) != null) {
                if (ignoreCase) {
                    line = line.toLowerCase();
                }

                if (count || duplicates || unique) {
                    countMap.put(line, countMap.getOrDefault(line, 0) + 1);
                } else {
                    writer.println(line);
                }
            }

            if (count || duplicates || unique) {
                for (Map.Entry<String, Integer> entry : countMap.entrySet()) {
                    if (count){
                        writer.println(entry.getValue() + " " + entry.getKey());
                    } else if (duplicates && entry.getValue() > 1){
                        writer.println(entry.getKey());
                    } else if (unique && entry.getValue() == 1){
                        writer.println(entry.getKey());
                    }
                }
            }

            reader.close();
            writer.close();
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
            System.exit(1);
        }
    }
}