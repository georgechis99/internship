package com.arobs.intenrship.lab4.ex1;

public class Circle {
    public static final double PI = 3.14;
    private final double radius;

    public Circle() {
        radius = 1.0;
        String color = "red";
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public double getArea() {
        return PI * Math.pow(radius,2);
    }
}
