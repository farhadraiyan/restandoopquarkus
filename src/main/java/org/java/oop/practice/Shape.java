package org.java.oop.practice;

public abstract class Shape {
    private Double length;
    public Shape(Double l){
        this.length = l;
    }
    public Double getLength(){
        return this.length;
    }
    public abstract Double calcArea(Double l, Double w);

}

class Rectangle extends Shape implements IRectangle{
    private Double width;
    public Rectangle(Double l, Double w) {
        super(l);
        this.width = w;
    }
    public Double getWidth(){
        return this.width;
    }

    //implementing abstract method from parent class
    //overdidding method
    @Override
    public Double calcArea(Double l, Double w) {
        return l*w;
    }

    public Double calcPerimeter(Double l, Double w) {
        return 2*(l+w);

    }

    public Double calcDiagonal(Double l, Double w) {
        return Math.sqrt(Math.pow(l, 2)+Math.pow(w, 2));
    }

}

class Triangle extends Shape{
    private Double height;
    private Double sideA;
    private Double sideB;
    private Double sideC;
    private Double perimeter;

    public Triangle(Double l, Double height, Double sideA, Double sideB, Double sideC) {
        super(l);
        this.height = height;
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }

    public Double calPerimeter(Double s1, Double s2, Double s3){
        return s1+s2+s3;
    }
        //overloaded method
    public Double calcArea(Double p, Double s1, Double s2, Double s3){
        Double semiPeri = p/2;
        return Math.sqrt(semiPeri*(semiPeri-s1)*(semiPeri-s2)*(semiPeri-s3));
    }
    public Double calcArea(Double b, Double h){
        return .5*(b*h);
    }

    public Double calcPerimeter(Double s1, Double s2, Double s3){
        return s1+s2+s3;
    }
    public Double getHeight(){
        return this.height;
    }

    public Double getSideA() {
        return sideA;
    }
    public Double getSideB() {
        return sideB;
    }
    public Double getSideC() {
        return sideC;
    }
}

interface IRectangle{
    public Double calcArea(Double l, Double w);
    public Double calcPerimeter(Double l, Double w );
    public Double calcDiagonal(Double l, Double w);
}