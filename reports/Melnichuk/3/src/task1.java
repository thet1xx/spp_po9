import static java.lang.Math.sqrt;



public class task1{
    public static void main(String[] args){
        IsoscelesTriangle a = new IsoscelesTriangle(3, 5);
        IsoscelesTriangle b = new IsoscelesTriangle(15, 21);
        System.out.println(a.square());
        System.out.println(a.perimeter());
        System.out.println(a.isExist());
        System.out.println(a.equals(b));
    }
}

class IsoscelesTriangle {
    private double base;
    private double sides;

    public IsoscelesTriangle(double base, double sides) {
        this.base = base;
        this.sides = sides;
    }

    public double square(){
        double height = sqrt(Math.pow(sides, 2) - Math.pow((base / 2), 2));
        return (base * height) / 2;
    }

    public double perimeter(){
        return 2 * sides + base;
    }
    public boolean isExist(){
        if(sides >= base / 2){
            return true;
        }
        return false;
    }

    public boolean equals(Object obj){
        if(this == obj){
            return true;
        }
        if(obj == null || getClass() != obj.getClass()){
            return false;
        }
        IsoscelesTriangle other = (IsoscelesTriangle) obj;
        return Double.compare(this.sides, other.sides) == 0 && Double.compare(this.base, other.base) == 0;
    }
}
