import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class Task_01 {

    public static void main(String[] args) {
        String nounsFile = "nouns.txt";
        String adjectivesFile = "adjectives.txt";
        String verbsFile = "verbs.txt";
        String prepositionsFile = "prepositions.txt";

        ArrayList<String> nouns = readFile(nounsFile);
        ArrayList<String> adjectives = readFile(adjectivesFile);
        ArrayList<String> verbs = readFile(verbsFile);
        ArrayList<String> prepositions = readFile(prepositionsFile);

        if (nouns.isEmpty() || adjectives.isEmpty() || verbs.isEmpty() || prepositions.isEmpty()) {
            System.err.println("Ошибка: Не удалось найти необходимые данные в файлах.");
            return;
        }

        Random random = new Random();
        for (int i = 0; i < 20; i++) {
            String sentence = generateSentence(nouns, adjectives, verbs, prepositions, random);
            System.out.println(sentence);
        }
    }

    private static ArrayList<String> readFile(String fileName) {
        ArrayList<String> words = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                words.add(line.trim());
            }
        } catch (IOException e) {
            System.err.println("Ошибка при чтении файла " + fileName + ": " + e.getMessage());
        }
        return words;
    }

    private static String generateSentence(ArrayList<String> nouns, ArrayList<String> adjectives,
                                           ArrayList<String> verbs, ArrayList<String> prepositions, Random random) {
        String noun = getRandomElement(nouns, random);
        String adjective = getRandomElement(adjectives, random);
        String verb = getRandomElement(verbs, random);
        String preposition = getRandomElement(prepositions, random);
        String secondNoun = getRandomElement(nouns, random);

        // Формирование предложения
        String sentence = noun + " " + verb + " " + preposition + " " + adjective + " " + secondNoun + ".";
        // Преобразование первой буквы в заглавную
        sentence = sentence.substring(0, 1).toUpperCase() + sentence.substring(1);
        return sentence;
    }

    private static String getRandomElement(ArrayList<String> list, Random random) {
        int index = random.nextInt(list.size());
        return list.get(index);
    }
}
