public class Paragraph {
    private String content;

    public Paragraph(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int countWords() {
        // Подсчитываем количество слов в абзаце
        String[] words = content.split("\\s+");
        return words.length;
    }
}
