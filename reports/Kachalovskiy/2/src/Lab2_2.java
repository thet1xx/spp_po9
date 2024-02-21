package Lab2;

import java.io.*;
import java.util.*;

public class Lab2_2 {
    public static void main(String[] args) throws Exception {
        if (args.length == 0 || !args[0].equals("uniq")){
            System.err.println("Usage Uniq [-c | -d | -u] [-i] [input_file] [output_file]");
            System.exit(1);
        }

        boolean count = false;
        boolean duplicates = false;
        boolean unique = false;
        boolean ignoreCase = false;
        String inputFile = null;
        String outputFile = null;

        for (int i = 1; i < args.length; i++) {
            switch (args[i]) {
                case "-c":
                    if (count || duplicates || unique) {
                        System.err.println("Error: Only one of -c, -d, -u can be used.");
                        System.exit(1);
                    }
                    count = true;
                    break;
                case "-d":
                    if (count || duplicates || unique) {
                        System.err.println("Error: Only one of -c, -d, -u can be used.");
                        System.exit(1);
                    }
                    duplicates = true;
                    break;
                case "-u":
                    if (count || duplicates || unique) {
                        System.err.println("Error: Only one of -c, -d, -u can be used.");
                        System.exit(1);
                    }
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