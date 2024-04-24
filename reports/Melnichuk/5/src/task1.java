abstract class Book {
    private int code;
    private String author;
    private String title;
    private int year;
    private String publisher;

    public Book(int code, String author, String title, int year, String publisher) {
        this.code = code;
        this.author = author;
        this.title = title;
        this.year = year;
        this.publisher = publisher;
    }

    public abstract void display();

    public String getPublisher() {
        return publisher;
    }

    public int getYear() {
        return year;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }
    public Integer getCode(){
        return code;
    }
}

class Guide extends Book{
    private String destiny;
    private int pages;
    public Guide(int code, String author, String title, int year, String publisher, String destiny, int pages){
        super(code, author, title, year, publisher);
        this.destiny = destiny;
        this.pages = pages;
    }
    @Override
    public void display(){
        System.out.println("Справочник\nКод: " + super.getCode() + "\nАвтор: " + super.getAuthor() + "\nНазвание: " + super.getTitle() + "\nГод: " + super.getYear() + "\nИздатель: " + super.getPublisher() + "\nПредназначение: " + destiny + "\nСтраницы: " + pages);
    }
}

class Encyclopedia extends Book{
    private String series;
    private int pages;
    public Encyclopedia(int code, String author, String title, int year, String publisher, String series, int pages){
        super(code, author, title, year, publisher);
        this.series = series;
        this.pages = pages;
    }
    public void display(){
        System.out.println("Энциклопедия\nКод: " + getCode() + "\nАвтор: " + getAuthor() + "\nНазвание: " + getTitle() + "\nГод: " + getYear() + "\nИздатель: " + getPublisher() + "\nСерия: " + series + "\nСтраницы: " + pages);
    }
}

public class task1 {
    public static void main(String[] args) {
        Guide book1 = new Guide(22110, "Б.А.Балтухин", "Биология в таблицах", 2017, "Айрис-пресс", "Школьная программа", 113);
        book1.display();
        Encyclopedia book2 = new Encyclopedia(33210, "В.А.Кудрянова", "Все о динозаврах", 2010, "Рамазан", "Экнциклопедия для детского сада", 32);
        book2.display();
    }
}