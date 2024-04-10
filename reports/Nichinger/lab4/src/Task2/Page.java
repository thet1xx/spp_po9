package Task2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.function.Predicate;

public class Page {
    private ArrayList<Word> words;

    public Page(){
        words = new ArrayList<>();
    }

    public ArrayList<Word> getWords() {
        return words;
    }

    public void setWords(ArrayList<Word> words) {
        this.words = words;
    }

    public Page addWord(Word word){
        words.add(word);
        return this;
    }

    public void removeWord(Word word){
        words.remove(word);
    }

    public void removeWords(Word word){
        words.removeIf(Predicate.isEqual(word));
    }

    public void showPage(){
        System.out.println(this);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Word word : words) {
            stringBuilder.append(word);
        }
        return stringBuilder.toString();
    }
}
