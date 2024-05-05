import java.util.Scanner;

public class Task1 {
    private double sideA;
    private double sideB;
    private double sideC;

    // Конструктор без параметров
    public Task1() {
        this.sideA = 0;
        this.sideB = 0;
        this.sideC = 0;
    }

    // Конструктор с начальной инициализацией
    public Task1(double sideA, double sideB, double sideC) {
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }

    // Метод определения площади
    public double calculateArea() {
        return 0.5 * sideA * sideB;
    }

    // Метод определения периметра
    public double calculatePerimeter() {
        return sideA + sideB + sideC;
    }

    // Логический метод, определяющий существует ли такой треугольник
    public boolean exists() {
        return (sideA + sideB > sideC) && (sideA + sideC > sideB) && (sideB + sideC > sideA);
    }

    // Переопределение метода toString()
    @Override
    public String toString() {
        return "{сторона A=" + sideA + ", сторона B=" + sideB + ", сторона C=" + sideC + "}";
    }

    // Переопределение метода equals()
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Task1 other = (Task1) obj;
        return Double.compare(this.sideA, other.sideA) == 0 &&
                Double.compare(this.sideB, other.sideB) == 0 &&
                Double.compare(this.sideC, other.sideC) == 0;
    }

    // Метод main для примеров использования
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите длину стороны A:");
        double sideA = scanner.nextDouble();

        System.out.println("Введите длину стороны B:");
        double sideB = scanner.nextDouble();

        System.out.println("Введите длину стороны C:");
        double sideC = scanner.nextDouble();

        scanner.close();

        // Создание объекта треугольника
        Task1 triangle = new Task1(sideA, sideB, sideC);

        // Вычисление и вывод площади треугольника
        double area = triangle.calculateArea();
        System.out.println("Площадь треугольника: " + area);

        // Вычисление и вывод периметра треугольника
        double perimeter = triangle.calculatePerimeter();
        System.out.println("Периметр треугольника: " + perimeter);

        // Проверка существует ли треугольник
        boolean exists = triangle.exists();
        System.out.println("Треугольник существует? - " + exists);

        // Вывод информации о треугольнике с помощью toString()
        System.out.println("Длины сторон треугольника: " + triangle);

        // Создание другого треугольника для сравнения
        Task1 anotherTriangle = new Task1(sideA, sideB, sideC);

        // Сравнение двух треугольников
        boolean isEqual = triangle.equals(anotherTriangle);
        System.out.println("Треугольники равны? - " + isEqual);
    }
}
