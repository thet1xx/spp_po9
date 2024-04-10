package Task2;

public class Word {
    private String word;

    public Word(String word){
        this.word = word;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public void showWord(){
        System.out.print(word);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || this.getClass() != obj.getClass()){
            return false;
        }
        Word word = (Word) obj;
        return word.getWord().equals(this.getWord());
    }

    @Override
    public String toString() {
        return word;
    }
}
