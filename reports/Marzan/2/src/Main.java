import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.io.RandomAccessFile;
import java.io.FileNotFoundException;
import java.io.ByteArrayOutputStream;

public class Main
{
    private static String shuffleWord(String word)
    {
        List<String> letters = Arrays.asList(word.split(""));
        Collections.shuffle(letters, new Random());
        String shuffledWord = "";
        for (String letter : letters)
        {
            shuffledWord += letter;
        }
        return shuffledWord;
    }

    private static void task1()
    {
        System.out.println("Task1");

        String fileName = "D:\\Java projects\\SPP_2\\input.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName)))
        {
            String line;
            while ((line = reader.readLine()) != null)
            {
                String[] words = line.split("\\s+");

                for (int i = 0; i < words.length; i++)
                {
                    String shuffledWord = shuffleWord(words[i]);
                    words[i] = shuffledWord;
                }

                String result = String.join(" ", words);
                System.out.println(result);
            }
        }
        catch (IOException e)
        {
            System.err.println("File reading error: " + e.getMessage());
        }
    }

    public static void main(String[] args)
    {
        task1();

        System.out.println("Task2");

        if (args.length == 0)
        {
            return;
        }

        int lineCount = 10;
        String filename = "";

        if (args[0].equals("head"))
        {
            if (args[1].equals("-n"))
            {
                if (args.length < 4)
                {
                    System.out.println("Incorrect key usage format -n");
                    return;
                }
                try
                {
                    lineCount = Integer.parseInt(args[2]);
                }
                catch (NumberFormatException e)
                {
                    System.out.println("Invalid value for the number of rows");
                    return;
                }

                filename = args[3];
            }
            else
            {
                filename = args[1];
            }

            try (RandomAccessFile file = new RandomAccessFile(filename, "r"))
            {
                String line;
                int count = 0;

                while ((line = readLine(file)) != null && count < lineCount)
                {
                    System.out.println(line);
                    ++count;
                }
            }
            catch (FileNotFoundException e)
            {
                System.out.println("Файл не найден: " + filename);
            }
            catch (IOException e)
            {
                System.out.println("Ошибка при чтении файла: " + e.getMessage());
            }
        }
        else
        {
            System.out.println("Unknown command");
        }
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        scanner.close();
    }

    private static String readLine(RandomAccessFile file) throws IOException
    {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        int nextByte;

        while ((nextByte = file.read()) != -1)
        {
            if (nextByte == '\r')
            {
                continue;
            }
            else if (nextByte == '\n')
            {
                break;
            }
            baos.write(nextByte);
        }

        return baos.toString("UTF-8");
    }
}