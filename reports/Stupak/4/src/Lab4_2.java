public class Lab4_2 {

    public static void main(String[] args) {
        Page page = new Page();
        Line line1= new Line();
        Line line2 = new Line();

        line1.addWord(new Word("Help"));
        line2.addWord(new Word("save me"));
        page.addLine(line1);
        page.addLine(line2);
       /* line1.addWord(new Page.Word("Hello"));
        line1.addWord(new Page.Word("World"));
        line2.addWord(new Page.Word("This"));
        line2.addWord(new Page.Word("is"));
        line2.addWord(new Page.Word("text"));
        page.addLine(line1);
        page.addLine(line2);*/
        System.out.println(page);
    }
}