package com.arobs.intenrship.lab4.ex1;

public class TestShapes {

    public static void main(String[] args) {
        Shape[] shapes = {new Circle("red",true,10),
                new Rectangle("green",true,2,3),
                new Square("blue",false,5)};

        System.out.println(shapes[0].toString() + "  A = " + shapes[0].getArea() + "  P = " + shapes[0].getPerimeter());
        System.out.println(shapes[1].toString() + "  A = " + shapes[1].getArea() + "  P = " + shapes[1].getPerimeter());
        System.out.println(shapes[2].toString() + "  A = " + shapes[2].getArea() + "  P = " + shapes[2].getPerimeter());
    }
}
