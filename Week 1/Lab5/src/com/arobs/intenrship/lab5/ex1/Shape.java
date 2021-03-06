package com.arobs.intenrship.lab5.ex1;

//Follow the instructions and implement the program according to specification .
// Create an appropriate test class for testing the program.
// For testing purpose you will create an array of shapes and then call and display
// getArea() and getPermiter() for each object in the array.

//In this exercise, Shape shall be defined as an abstract class, which contains:
//
//Two protected instance variables color(String) and filled(boolean).
// The protected variables can be accessed by its subclasses and classes in the same package.
// They are denoted with a '#' sign in the class diagram.
//Getter and setter for all the instance variables, and toString().
//Two abstract methods getArea() and getPerimeter() (shown in italics in the class diagram).
//The subclasses Circle and Rectangle shall override the abstract methods getArea() and getPerimeter() and
// provide the proper implementation. They also override the toString().

public abstract class Shape {
    protected String color;
    protected boolean filled;

    public Shape() {
    }

    public Shape(String color, boolean filled) {
        this.color = color;
        this.filled = filled;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isFILLED() {
        return filled;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    public abstract double getArea();

    public abstract double getPerimeter();

    @Override
    public String toString() {
        return "Shape{" +
                "color='" + color + '\'' +
                ", filled=" + filled +
                '}';
    }
}
