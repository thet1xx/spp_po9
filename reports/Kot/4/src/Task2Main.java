public class Task2Main {
    public static void main(String[] args) {
        Paragraph paragraph1 = new Paragraph("Это первый абзац.");
        Paragraph paragraph2 = new Paragraph("Это второй абзац.");

        Text text = new Text();
        text.addParagraph(paragraph1);
        text.addParagraph(paragraph2);

        System.out.println("Количество абзацев: " + text.countParagraphs());
        System.out.println("Количество слов: " + text.countWords());

        System.out.println("Содержимое текста:");
        text.display();
    }
}
