package Lab4_2;

import java.util.ArrayList;
import java.util.List;

public class Page {

    private List<Line> lines;

    public Page() {
        this.lines = new ArrayList<>();
    }

    public void addLine(Line line) {
        lines.add(line);
    }

    public List<Line> getLines() {
        return lines;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Line line : lines) {
            sb.append(line).append("\n");
        }
        return sb.toString();
    }

    public static class Line {

        private List<Word> words;

        public Line() {
            this.words = new ArrayList<>();
        }

        public void addWord(Word word) {
            words.add(word);
        }

        public List<Word> getWords() {
            return words;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            for (Word word : words) {
                sb.append(word).append(" ");
            }
            return sb.toString().trim();
        }
    }


    public static class Word {

        private String text;

        public Word(String text) {
            this.text = text;
        }

        @Override
        public String toString() {
            return text;
        }
    }
}
