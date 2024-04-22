public class EquilateralTriangle {
    private final double side;
;

    public EquilateralTriangle(double side) {
        this.side = side;
    }

    public double getSideLength() {
        return side;
    }


    public double calculatePerimeter() {
        if (!isTriangle()) {
            System.out.println("Треугольник не существует. Невозможно вычислить периметр.");
            return 0;
        }
        return side*3;
    }


    public double calculateArea() {
        if (!isTriangle()) {
            System.out.println("Треугольник не существует. Невозможно вычислить площадь.");
            return 0;
        }
        return (Math.sqrt(3) / 4) * Math.pow(side, 2);
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        EquilateralTriangle that = (EquilateralTriangle) obj;
        return Double.compare(that.side, side) == 0;
    }


    @Override
    public String toString() {
        return "Это равносторонний треугольник. Длина стороны: " + side;
    }


    public boolean isTriangle() {
        return side > 0;
    }
}










