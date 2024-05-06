import java.util.regex.Pattern;
class Symbol {
    private char symbol;
    private static final Pattern RUSSIAN_VOWELS = Pattern.compile("[аеёиоуыэюяАЕЁИОУЫЭЮЯ]");
    private static final Pattern RUSSIAN_CONSONANTS = Pattern.compile("[бвгджзйклмнпрстфхцчшщБВГДЖЗЙКЛМНПРСТФХЦЧШЩ]");

    public Symbol(char symbol) {
        this.symbol = symbol;
    }

    public char getSymbol() {
        return symbol;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    public boolean isVowel() {
        return RUSSIAN_VOWELS.matcher(Character.toString(symbol)).matches();
    }
}

class Word {
    private String word;

    public Word(String word) {
        this.word = word;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public int getLength() {
        return word.length();
    }

    public boolean startsWithVowel() {
        return new Symbol(word.charAt(0)).isVowel();
    }
}

class Sentence {
    private Word[] words;

    public Sentence(Word[] words) {
        this.words = words;
    }

    public Word[] getWords() {
        return words;
    }

    public void setWords(Word[] words) {
        this.words = words;
    }

    public int wordCount() {
        return words.length;
    }

    public int totalWordLength() {
        int totalLength = 0;
        for (Word word : words) {
            totalLength += word.getLength();
        }
        return totalLength;
    }
}

public class Main2 {
    public static void main(String[] args) {
        Symbol symbol1 = new Symbol('Ю');
        Symbol symbol2 = new Symbol('Д');

        Word word1 = new Word("Привет");
        Word word2 = new Word("Мир");

        Word[] words = {word1, word2};
        Sentence sentence = new Sentence(words);

        System.out.println("Количество символов в строке символов: " + sentence.wordCount());
        System.out.println("Общая длина слов в строке: " + sentence.totalWordLength());

        // Additional usage of class methods
        System.out.println("Первое слово начинается с гласной буквы: " + word1.startsWithVowel());
        System.out.println("Символ 1 является гласной: " + symbol1.isVowel());
    }
}

