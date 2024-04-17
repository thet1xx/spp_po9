public class EquilateralTriangle {
    private final double side1;
    private final double side2;
    private final double side3;

    public EquilateralTriangle(double side1, double side2, double side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    public boolean isEquilateral() {
        return side1 == side2 && side2 == side3;
    }


    public double[] getSideLengths() {
        return new double[] {side1, side2, side3};
    }


    public double calculatePerimeter() {
        if (!isTriangle()) {
            System.out.println("Треугольник не существует. Невозможно вычислить периметр.");
            return 0;
        }
        return side1 + side2 + side3;
    }


    public double calculateArea() {
        if (!isTriangle()) {
            System.out.println("Треугольник не существует. Невозможно вычислить площадь.");
            return 0;
        }
        double s = calculatePerimeter() / 2;
        return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        EquilateralTriangle that = (EquilateralTriangle) obj;
        return Double.compare(that.side1, side1) == 0 &&
                Double.compare(that.side2, side2) == 0 &&
                Double.compare(that.side3, side3) == 0;
    }


    @Override
    public String toString() {
        return isEquilateral()?"Это равносторонний треугольник" : "Это неравносторонний треугольник";
    }


    public boolean isTriangle() {
        boolean condition1 = (side1 + side2 > side3);
        boolean condition2 = (side2 + side3 > side1);
        boolean condition3 = (side1 + side3 > side2);
        return condition1 && condition2 && condition3;
    }
}










