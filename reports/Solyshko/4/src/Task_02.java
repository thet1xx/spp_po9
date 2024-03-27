import java.util.ArrayList;

class Word {
    private String word;

    public Word(String word) {
        this.word = word;
    }

    public String getWord() {
        return word;
    }

    public int length() {
        return word.length();
    }
}

class Page {
    private ArrayList<Word> words;

    public Page(ArrayList<Word> words) {
        this.words = words;
    }

    public void addWord(Word word) {
        words.add(word);
    }

    public int wordCount() {
        return words.size();
    }

    public void displayWords() {
        System.out.println("Words on the page:");
        for (Word word : words) {
            System.out.print(word.getWord() + " ");
        }
        System.out.println();
    }
    public int totalLength() {
        int totalLengthOfWords = 0;
        for (Word word : words) {
            totalLengthOfWords += word.length();
        }
        return totalLengthOfWords;
    }
}

public class Task_02 {
    public static void main(String[] args) {
        Word word1 = new Word("Dima");
        Word word2 = new Word("Solyshko");

        ArrayList<Word> pageWords = new ArrayList<>();
        pageWords.add(word1);
        pageWords.add(word2);
        Page page = new Page(pageWords);

        Word word3 = new Word("Andreevich");
        page.addWord(word3);

        page.displayWords();

        System.out.println("Total words on the page: " + page.wordCount());
        System.out.println("Total length of words on the page: " + page.totalLength());
    }
}
