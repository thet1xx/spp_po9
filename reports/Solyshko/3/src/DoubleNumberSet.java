import java.util.Arrays;

public class DoubleNumberSet {
    private double[] elements;
    private int capacity;
    private int size;

    public DoubleNumberSet(int capacity) {
        this.capacity = capacity;
        this.elements = new double[capacity];
        this.size = 0;
    }

    public void addElement(double element) {
        if(!this.contains(element)){
            if (size < capacity) {
                elements[size++] = element;
            }
            else {
                System.out.println("Множество полное, невозможно добавить новый элемент.");
            }
        }
    }

    public void removeElement(double element) {
        int index = indexOf(element);
        if (index != -1) {
            System.arraycopy(elements, index + 1, elements, index, size - index - 1);
            size--;
        } else {
            System.out.println("Элемент не найден в множестве.");
        }
    }

    public boolean contains(double element) {
        return indexOf(element) != -1;
    }

    public DoubleNumberSet union(DoubleNumberSet otherSet) {
        int newCapacity = this.capacity + otherSet.capacity;
        DoubleNumberSet newSet = new DoubleNumberSet(newCapacity);

        System.arraycopy(this.elements, 0, newSet.elements, 0, this.size);
        newSet.size = this.size;

        for (int i = 0; i < otherSet.size; i++) {
            if (!newSet.contains(otherSet.elements[i])) {
                newSet.addElement(otherSet.elements[i]);
            }
        }

        return newSet;
    }

    private int indexOf(double element) {
        for (int i = 0; i < size; i++) {
            if (elements[i] == element) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOf(elements, size));
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        DoubleNumberSet that = (DoubleNumberSet) obj;
        return Arrays.equals(elements, that.elements);
    }
}
