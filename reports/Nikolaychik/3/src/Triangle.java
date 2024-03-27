public class Triangle {
    protected double catet_a,catet_b;

    public Triangle() {
        this.catet_a=5;
        this.catet_b=5;
    }
    public Triangle(Triangle tri) {
        this.catet_a=tri.catet_a;
        this.catet_b=tri.catet_b;
    }
    public Triangle(double a,double b) {
        this.catet_a=a;
        this.catet_b=b;
    }

    public double getCatet_a() {
        return catet_a;
    }

    public double getCatet_b() {
        return catet_b;
    }

    public void setCatet_a(double catet_a) {
        this.catet_a = catet_a;
    }

    public void setCatet_b(double catet_b) {
        this.catet_b = catet_b;
    }

    public double perimeter(){
        return this.catet_a + this.catet_b +
                Math.sqrt(this.catet_a*this.catet_a + this.catet_b*this.catet_b);
    }
    public double square(){
        return this.catet_b*this.catet_a/2;
    }
    public void output(){
        System.out.println("PERIMETER " + this.perimeter());
        System.out.println("S "+this.square());
    }
    public boolean equals(Triangle a){
        if(this.catet_a==a.catet_a && this.catet_b==a.catet_b)
            return  true;
        return false;
    }
    public String toString(){
        return Double.toString(this.catet_a) + ";" + Double.toString(this.catet_b);
    }
}
