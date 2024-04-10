import java.util.ArrayList;
import java.util.List;

class Line {
    private List<Word> words;

    public Line(){
        words = new ArrayList<>();
    }
    public void addWord(Word word){
        words.add(word);
    }
    public List<Word> getWords(){
        return words;
    }
}

class Word{
    private List<Symbol> symbols;
    public Word(){
        symbols = new ArrayList<>();
    }
    public void addSymbol(Symbol symbol){
        symbols.add(symbol);
    }
    public List<Symbol> getSymbols(){
        return symbols;
    }
}

class Symbol {
    private char symbol;

    public Symbol(char symbol){
        this.symbol = symbol;
    }

    public char getSymbol(){
        return symbol;
    }
}

class task2{
    public static void main(String[] args){
        Symbol symbol1 = new Symbol('П');
        Symbol symbol2 = new Symbol('Р');
        Symbol symbol3 = new Symbol('И');
        Symbol symbol4 = new Symbol('В');
        Symbol symbol5 = new Symbol('Е');
        Symbol symbol6 = new Symbol('Т');

        Word word1 = new Word();
        word1.addSymbol(symbol1);
        word1.addSymbol(symbol2);

        Word word2 = new Word();
        word2.addSymbol(symbol3);
        word2.addSymbol(symbol4);
        word2.addSymbol(symbol5);
        word2.addSymbol(symbol6);

        Line line = new Line();
        line.addWord(word1);
        line.addWord(word2);

        List<Word> words = line.getWords();
        for(Word word : words){
            List<Symbol> symbols = word.getSymbols();
            for(Symbol symbol : symbols){
                System.out.print(symbol.getSymbol());
            }

        }
    }

}
