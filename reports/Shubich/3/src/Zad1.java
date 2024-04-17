package org.example;

import java.util.Objects;


public class Zad1 {
    private final static double pi = 3.14;
    private double a;
    private double b;
    private double c;

    public Zad1(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public boolean isIsoscelesTraingle() {
        if ((a + b > c) && (a + c > b) && (b + c > a)) {

        } else {
            System.out.println("Это не треугольник");
            return false;
        }

        if (a <= 0 || b <= 0 || c <= 0) {
            System.out.println("Стороны треугольника должны быть больше нуля и" +
                    "\n  для равнобедренного треугольника две стороны должны быть равны!");
            return false;
        }
        return a == b || a == c || b == c;
    }

    public Zad1() {
    }

    public double perimeter(){
        if (!isIsoscelesTraingle()) {
            return 0.0;
        }

        return a+b+c;
    }

    public double area(){
        if (!isIsoscelesTraingle()) {
            return 0.0;
        }
        if (a == b) {
           return areaForIsosceles(a, c);
        } else if (c == a) {
            return areaForIsosceles(a, b);
        } else {
           return areaForIsosceles(b, a);
        }
    }

    private double areaForIsosceles(double a, double b) {
        return Math.round(0.5 * b * Math.sqrt(Math.pow(a,2) - (Math.pow(b,2)/4)) * 100.0) / 100.0 ;
    }

    @Override
    public String toString() {
        return "Zad1{" +
                "a=" + a +
                ", b=" + b +
                ", c=" + c +
                '}';
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getC() {
        return c;
    }

    public void setA(double a) {
        this.a = a;
    }

    public void setB(double b) {
        this.b = b;
    }

    public void setC(double c) {
        this.c = c;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Zad1 zad1)) return false;
        return Double.compare(a, zad1.a) == 0 && Double.compare(b, zad1.b) == 0 && Double.compare(c, zad1.c) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(a, b, c);
    }
}
