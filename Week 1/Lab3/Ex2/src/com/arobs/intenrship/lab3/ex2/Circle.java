package com.arobs.intenrship.lab3.ex2;

public class Circle {
    private static final double PI = 3.14;

    private double radius;
    private String color;

    public Circle() { //default constructor
        radius = 1.0;
        color = "red";
    }

    public Circle(double radius) {  //partially explicit constructor 1
        this.radius = radius;
        color = "red";
    }

    public Circle(String color) { //partially explicit constructor 1
        radius = 1.0;
        this.color = color;
    }

    public Circle(double radius, String color) { //explicit constructor
        this.radius = radius;
        this.color = color;
    }

    public double getRadius() {  //getter for the circle's radius
        return radius;
    }

    public String getColor() {  //getter for the circle's color
        return color;
    }

    public double getArea() {  //method that returns the area of the circle
        return 2 * PI * radius;
    }

    public void setRadius(double radius) {  //setter for the circle's radius
        this.radius = radius;
    }

    public void setColor(String color) {  //setter for the circle's color
        this.color = color;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                ", color='" + color + '\'' +
                '}';
    }
}
