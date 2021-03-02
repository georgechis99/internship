package com.arobs.intenrship.lab3.ex2;

public class Main {

    public static void main(String[] args) {

        //A class called Circle contains:
        //
        //Two private instance variables: radius (of type double) and color (of type String), with default value of 1.0 and “red”, respectively.
        //Two overloaded constructors;
        //Two public methods: getRadius() and getArea().
        //Write a class which models the class Circle. Write a class TestCircle which test Circle class.

        TestCircle tc1 = new TestCircle();
        tc1.displayCircleAttributes();

        TestCircle tc2 = new TestCircle(10);
        tc2.displayCircleAttributes();

        TestCircle tc3 = new TestCircle("blue");
        tc3.displayCircleAttributes();

        TestCircle tc4 = new TestCircle(5, "cyan");
        tc4.displayCircleAttributes();

        tc1.redefineCircle();
        tc1.displayCircleAttributes();
    }
}
