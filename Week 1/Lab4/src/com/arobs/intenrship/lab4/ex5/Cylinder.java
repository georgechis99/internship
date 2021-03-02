package com.arobs.intenrship.lab4.ex5;

import com.arobs.intenrship.lab4.ex1.Circle;

public class Cylinder extends Circle {
    private double height;

    public Cylinder() {
        super();
    }

    public Cylinder(double radius) {
        super(radius);
    }

    public Cylinder(double radius, double height) {
        super(radius);
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    @Override
    public double getArea() {
        return ((2 * PI * this.getRadius() * height) + (2 * PI + Math.pow(this.getRadius(), 2)));
    }

    public double getVolume() {
        return PI * Math.pow(this.getRadius(), 2) * height; //????????????
    }
}
