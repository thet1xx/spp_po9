//import java.util.Scanner;
//
//public class Task1 {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//
//        System.out.print("Введите текст: ");
//        String text = scanner.nextLine();
//
//        System.out.print("Введите слово-эталон: ");
//        String wordToMatch = scanner.nextLine();
//
//        findAndPrintSimilarWords(text, wordToMatch);
//
//        scanner.close();
//    }
//
//    public static void findAndPrintSimilarWords(String text, String wordToMatch) {
//        String[] words = text.split("[^а-яА-Я]+");
//
//        System.out.println("Похожие слова для слова \"" + wordToMatch + "\":");
//
//        int count = 0;
//        for (String word : words) {
//            if (isSimilar(wordToMatch, word)) {
//                count++;
//                System.out.println(count + ". " + word);
//            }
//        }
//
//        if (count == 0) {
//            System.out.println("Похожих слов не найдено.");
//        }
//    }
//
//    public static boolean isSimilar(String wordToMatch, String similarWord) {
//
//        int matchCount = 0;
//        for (int i = 0; i < wordToMatch.length(); i++) {
//            char charToMatch = wordToMatch.charAt(i);
//            char similarChar = similarWord.charAt(i);
//
//            // Сравниваем символы, учитывая их регистр
//            if (charToMatch == similarChar || Character.toLowerCase(charToMatch) == Character.toLowerCase(similarChar)) {
//                matchCount++;
//            }
//        }
//
//        // Проверяем, достигает ли количество совпадений порога в 50%
//        return (double) matchCount / wordToMatch.length() > 0.5;
//    }
//}

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = readTextFromFile("spp2_1.txt"); // Добавляем чтение текста из файла

        System.out.print("Введите слово-эталон: ");
        String wordToMatch = scanner.nextLine();

        findAndPrintSimilarWords(text, wordToMatch);

        scanner.close();
    }

    // Метод для чтения текста из файла
    public static String readTextFromFile(String fileName) {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    // Метод для поиска и вывода похожих слов
    public static void findAndPrintSimilarWords(String text, String wordToMatch) {
        // Разбиваем текст на слова
        String[] words = text.split("[^а-яА-Я]+");

        System.out.println("Похожие слова для слова \"" + wordToMatch + "\":");

        int count = 0;
        // Проверяем каждое слово из текста
        for (String word : words) {
            // Если слово похоже на слово-эталон, выводим его
            if (isSimilar(wordToMatch, word)) {
                count++;
                System.out.println(count + ". " + word);
            }
        }
        // Если не найдено похожих слов, выводим сообщение
        if (count == 0) {
            System.out.println("Похожих слов не найдено.");
        }
    }

    // Метод для проверки, является ли слово похожим на слово-эталон
    public static boolean isSimilar(String wordToMatch, String similarWord) {
        int matchCount = 0;
        // Сравниваем символы слов поочередно
        for (int i = 0; i < wordToMatch.length(); i++) {
            char charToMatch = wordToMatch.charAt(i);
            char similarChar = similarWord.charAt(i);

            // Если символы совпадают или совпадают после приведения к одному регистру, увеличиваем счетчик
            if (charToMatch == similarChar || Character.toLowerCase(charToMatch) == Character.toLowerCase(similarChar)) {
                matchCount++;
            }
        }

        // Проверяем, достигает ли количество совпадений порога в 50%
        return (double) matchCount / wordToMatch.length() > 0.5;
    }
}






