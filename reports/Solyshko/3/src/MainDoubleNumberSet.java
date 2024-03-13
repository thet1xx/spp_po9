
public class MainDoubleNumberSet {
    public static void main(String[] args) {
        DoubleNumberSet set1 = new DoubleNumberSet(5);
        set1.addElement(1.0);
        set1.addElement(2.0);
        set1.addElement(3.1);
        set1.addElement(49.2);
        set1.removeElement(3.1);
        set1.addElement(3.0);
        set1.addElement(2.0);

        System.out.println("множество set1: " + set1);

        DoubleNumberSet set2 = new DoubleNumberSet(5);
        set2.addElement(2.0);
        set2.addElement(3.0);
        set2.addElement(4.0);
        set2.addElement(5.0);
        set2.addElement(6.0);
        set2.addElement(9.0); // проверка на полноту множества

        System.out.println("множество set2: " + set2);

        DoubleNumberSet unionSet = set1.union(set2);
        System.out.println("Объединение множеств: " + unionSet);

        System.out.println("Принадлежит ли 4.0 множеству set1: " + set1.contains(4.0));

        set1.removeElement(2.0);
        System.out.println("Множество set1 после удаления элемента 2.0: " + set1);

        boolean areEqual = set1.equals(set2);

        if (areEqual) {
            System.out.println("Множества set1 и set2 равны.");
        } else {
            System.out.println("Множества set1 и set2 не равны.");
        }

        // Сделаем идентичные элементы у обьекты set3 и set2, но с разными мощностями, и проверим равенство
        DoubleNumberSet set3 = new DoubleNumberSet(6);
        set3.addElement(2.0);
        set3.removeElement(2.0);
        set3.addElement(2.0);
        set3.addElement(3.0);
        set3.addElement(4.0);
        set3.addElement(5.0);
        set3.addElement(6.0);

        // Сделаем идентичные обьекты set3 и set4 и проверим равенство
        DoubleNumberSet set4 = new DoubleNumberSet(6);
        set4.addElement(2.0);
        set4.addElement(3.0);
        set4.addElement(4.0);
        set4.addElement(5.0);
        set4.addElement(6.0);

        areEqual = set3.equals(set4);

        if (areEqual) {
            System.out.println("Множества set3 и set4 равны.");
        } else {
            System.out.println("Множества set3 и set4 не равны.");
        }
    }
}
