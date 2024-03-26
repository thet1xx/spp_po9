package Lab4_2;

public class Lab4_2 {

    public static void main(String[] args) {
        Page page = new Page();
        Page.Line line1 = new Page.Line(), line2 = new Page.Line();
        line1.addWord(new Page.Word("Hello"));
        line1.addWord(new Page.Word("World"));
        line2.addWord(new Page.Word("This"));
        line2.addWord(new Page.Word("is"));
        line2.addWord(new Page.Word("text"));
        page.addLine(line1);
        page.addLine(line2);
        System.out.println(page);
    }
}
