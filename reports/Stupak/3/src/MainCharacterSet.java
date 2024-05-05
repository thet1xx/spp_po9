public class MainCharacterSet {
    public static void main(String[] args) {
        CharacterSet set1 = new CharacterSet(5);
        set1.add('a');
        set1.add('b');
        CharacterSet set2 = new CharacterSet(5);
        set2.add('c');
        set2.add('d');
        set2.add('e');
        set1.print();
        set2.print();
        set1.union(set2);
        set1.print();
        System.out.println("Множество set1 содержит 'c': " +
                set1.contains('c'));
        System.out.println("Множество set1 содержит 'z': " +
                set1.contains('z'));
        set1.remove('c');
        set1.print();
        System.out.println("Множества set1 и set2 равны: " +
                set1.equals(set2));
    }
}
