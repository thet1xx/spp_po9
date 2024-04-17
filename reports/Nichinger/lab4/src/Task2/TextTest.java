package Task2;

public class TextTest {
    public static void main(String[] args) {
        Page firstPage = new Page();
        firstPage.addWord(new Word("Lorem "))
                 .addWord(new Word("ipsum,\n"))
                 .addWord(new Word("dolor "))
                 .addWord(new Word("consectetur."));

        Page secondPage = new Page();
        secondPage.addWord(new Word("Excepteur "))
                .addWord(new Word("sint,\n"))
                .addWord(new Word("occaecat "))
                .addWord(new Word("cupidatat."));

        Text text = new Text();
        text.addPage(firstPage).addPage(secondPage);
        System.out.println(text);
//        text.showText();
    }
}
