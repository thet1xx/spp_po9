public class CharacterSet {
    private char[] set;
    private int size;
    public CharacterSet(int capacity) {
        set = new char[capacity];
        size = 0;
    }
    public void add(char element) {
        if (!contains(element)) {
            if (size < set.length) {
                set[size++] = element;
            }
        }
    }
    public void remove(char element) {
        for (int i = 0; i < size; i++) {
            if (set[i] == element) {
                set[i] = set[size - 1];
                size--;
                return;
            }
        }
    }
    public boolean contains(char element) {
        for (int i = 0; i < size; i++) {
            if (set[i] == element) {
                return true;
            }
        }
        return false;
    }
    public void union(CharacterSet otherSet) {
        for (int i = 0; i < otherSet.size; i++) {
            if (!contains(otherSet.set[i])) {
                add(otherSet.set[i]);
            }
        }
    }
    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.print(set[i] + " ");
        }
        System.out.println();
    }
    public boolean equals(CharacterSet otherSet) {
        if (this.size != otherSet.size) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (this.set[i] != otherSet.set[i]) {
                return false;
            }
        }
        return true;
    }
}
