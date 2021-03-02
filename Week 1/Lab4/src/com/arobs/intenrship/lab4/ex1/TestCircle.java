package com.arobs.intenrship.lab4.ex1;

public class TestCircle {

    public static void main(String[] args) {
        Circle c1 = new Circle();
        Circle c2 = new Circle();

        System.out.println("Circle 1:" + "\n" + printCircleInfo(c1));
        System.out.println("Circle 2:" + "\n" + printCircleInfo(c2));

        c1 = new Circle(3.75);
        c2 = new Circle(5);

        System.out.println("Circle 1:" + "\n" + printCircleInfo(c1));
        System.out.println("Circle 2:" + "\n" + printCircleInfo(c2));
    }

    public static String printCircleInfo(Circle c) {
        return ("\tRadius: " + c.getRadius() + "\n" +
                           "\tArea: " + c.getArea() + "\n");
    }
}
