package com.arobs.intenrship.lab3.ex4;

public class TestMyPoint {

    public static void main(String[] args) {

        //A class called MyPoint, which models a 2D point with x and y coordinates contains:
        //
        //Two instance variables x (int) and y (int).
        //A “no-argument” (or “no-arg”) constructor that construct a point at (0, 0).
        //A constructor that constructs a point with the given x and y coordinates.
        //Getter and setter for the instance variables x and y.
        //A method setXY() to set both x and y.
        //A toString() method that returns a string description of the instance in the format “(x, y)”.
        //A method called distance(int x, int y) that returns the distance from this point to another point at the given (x, y) coordinates.
        //An overloaded distance(MyPoint another) that returns the distance from this point to the given MyPoint instance another.
        //Write the code for the class MyPoint. Also write a test class (called TestMyPoint) to test all the methods defined in the class.

        MyPoint p1 = new MyPoint();
        System.out.println(p1.toString());

        p1 = new MyPoint(2, 2);
        System.out.println(p1.toString());

        System.out.println("Distance to a point (1,2) is: " + p1.distance(1, 2)); //sqrt 1 + 0
        System.out.println("Distance to a point (5,4) is: " + p1.distance(5, 6)); //sqrt 9 + 16 = sqrt 25 = 5

        MyPoint p2 = new MyPoint();
        System.out.println(p2.toString());

        p2.setXY(16, 2);
        System.out.println(p2.toString());

        System.out.println("Distance from p2(16,2) to p1(2,2) is: " + p1.distance(p2));
        System.out.println("Distance from p2(16,2) to p1(2,2) is: " + p2.distance(p1));

    }
}
