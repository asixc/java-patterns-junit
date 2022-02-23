package com.example.creational.prototype;

public class Main {

    public static void main(String[] args) {

        Shape circle = new Circle("azul", 10);

        Shape circle2 = circle.copy();
        circle2.setColor("rojo");

        Circle circle3 = (Circle) circle.copy();
        System.out.println(circle3);
    }

}

abstract class Shape {

    private String color;

    protected Shape(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public abstract Shape copy();
}

class Circle extends Shape{

    int radius;

    protected Circle(String color, int radius) {
        super(color);
        this.radius = radius;
    }

    public Shape copy() {
        return new Circle(this.getColor(), this.radius);
    }
}