import java.util.ArrayList;
import java.util.List;

public class Text {
    private List<Paragraph> paragraphs;

    public Text() {
        this.paragraphs = new ArrayList<>();
    }

    public void addParagraph(Paragraph paragraph) {
        paragraphs.add(paragraph);
    }

    public void removeParagraph(Paragraph paragraph) {
        paragraphs.remove(paragraph);
    }

    public int countParagraphs() {
        return paragraphs.size();
    }

    public int countWords() {
        int totalWords = 0;
        for (Paragraph paragraph : paragraphs) {
            totalWords += paragraph.countWords();
        }
        return totalWords;
    }

    public void display() {
        for (Paragraph paragraph : paragraphs) {
            System.out.println(paragraph.getContent());
        }
    }
}
