package Task2;

import java.util.ArrayList;

/*
TODO Реализовать агрегирование.
     При создании класса агрегируемый класс объявляется как атрибут (локальная переменная).
     Включить в каждый класс 2-3 метода на выбор. Продемонстрировать использование разработанных классов

TODO Создать класс Текст, используя классы Страница, Слово.
*/
public class Text {
    ArrayList<Page> pages;

    public Text(){
        pages = new ArrayList<>();
    }

    public ArrayList<Page> getPages() {
        return pages;
    }

    public void setPages(ArrayList<Page> pages) {
        this.pages = pages;
    }

    public Text addPage(Page page){
        pages.add(page);
        return this;
    }

    public void removePage(Page page){
        pages.remove(page);
    }

    public void showText(){
        System.out.println(this);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < pages.size(); i++) {
            stringBuilder.append(String.format("\tPage %d\n", i + 1));
            stringBuilder.append(pages.get(i));
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
}
