package com.arobs.intenrship.lab4.ex6;

public class TestShapes {

    public static void main(String[] args) {
        Circle c = new Circle("red", false, 5);
        System.out.println(c.toString());
        System.out.println("A=" + c.getArea() + " P=" + c.getPerimeter());

        Rectangle r = new Rectangle("green", true, 10.25, 10.25);
        System.out.println(r.toString());
        System.out.println("A=" + r.getArea() + " P=" + r.getPerimeter());

        Square s = new Square("cyan", false, 5);
        System.out.println(s.toString());

        s.setWidth(8);
        System.out.println(s.toString());

        System.out.println("A=" + s.getArea());
        System.out.println("P=" + s.getPerimeter());

    }
}
