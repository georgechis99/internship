package com.arobs.intenrship.lab4.ex5;

public class TestCylinder {

    public static void main(String[] args) {
        Cylinder cylinder1 = new Cylinder(5, 5);
        Cylinder cylinder2 = new Cylinder(2, 10);

        System.out.println("Cylinder 1: " + "\n" +
                "\tArea: " + cylinder1.getArea() + "\n" +
                "\tVolume: " + cylinder1.getVolume() + "\n\n");

        System.out.println("Cylinder 2: " + "\n" +                "\tArea: " + cylinder2.getArea() + "\n" +
                "\tVolume: " + cylinder2.getVolume() + "\n\n");
    }
}
