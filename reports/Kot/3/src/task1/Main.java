import java.math.BigInteger;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<BigInteger> set1Elements = new ArrayList<>();
        set1Elements.add(BigInteger.valueOf(1));
        set1Elements.add(BigInteger.valueOf(2));
        set1Elements.add(BigInteger.valueOf(3));
        BigIntegerSet set1 = new BigIntegerSet(set1Elements);
        System.out.println("Set 1: " + set1.toString());

        BigIntegerSet set2 = new BigIntegerSet();
        set2.addElement(BigInteger.valueOf(2));
        set2.addElement(BigInteger.valueOf(3));
        set2.addElement(BigInteger.valueOf(4));
        System.out.println("Set 2: " + set2.toString());

        // Проверка методов
        System.out.println("Is 2 in set1? "
                + set1.contains(BigInteger.valueOf(2)));
        System.out.println("Is 4 in set1? "
                + set1.contains(BigInteger.valueOf(4)));
        System.out.println("Intersection of set1 and set2: "
                + set1.intersection(set2));
        System.out.println("Set1 == Set2? " + set1.equals(set2));

        // Добавление элемента в множество
        set1.addElement(BigInteger.valueOf(4));
        System.out.println("Set 1 after adding 4: " + set1.toString());

        // Удаление элемента из множества
        set2.removeElement(BigInteger.valueOf(4));
        System.out.println("Set 2 after removing 4: " + set2.toString());
    }
}
