import java.math.BigInteger;
import java.util.ArrayList;

public class BigIntegerSet {
    private ArrayList<BigInteger> elements;

    public BigIntegerSet() {
        this.elements = new ArrayList<>();
    }

    public BigIntegerSet(ArrayList<BigInteger> initialElements) {
        this.elements = new ArrayList<>(initialElements);
    }

    public void addElement(BigInteger element) {
        if (!elements.contains(element)) {
            elements.add(element);
        }
    }

    public void removeElement(BigInteger element) {
        elements.remove(element);
    }

    public boolean contains(BigInteger element) {
        return elements.contains(element);
    }

    public BigIntegerSet intersection(BigIntegerSet otherSet) {
        ArrayList<BigInteger> intersectionElements = new ArrayList<>();
        for (BigInteger element : elements) {
            if (otherSet.contains(element)) {
                intersectionElements.add(element);
            }
        }
        return new BigIntegerSet(intersectionElements);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof BigIntegerSet)) return false;
        BigIntegerSet otherSet = (BigIntegerSet) obj;
        return this.elements.equals(otherSet.elements);
    }

    @Override
    public String toString() {
        return elements.toString();
    }
}
