package com.arobs.intenrship.lab5.ex1;

public class Square extends Rectangle {

    public Square() {
        super();
    }

    public Square(double side) {
        super();
        this.setLength(side);
        this.setWidth(side);
    }

    public Square(String color, boolean filled, double side) {
        super(color, filled, side, side);
    }

    public void setSide(double side) {
        this.setLength(side);
        this.setWidth(side);
    }

    public double getSide() {
        return this.getLength();
    }

    @Override
    public void setWidth(double side) {
        this.setLength(side);
        this.setWidth(side);
    }

    @Override
    public void setLength(double side) {
        this.setLength(side);
        this.setWidth(side);
    }

    @Override
    public String toString() {
        return "Square{" +
                "side=" + width +
                ", color='" + color + '\'' +
                ", filled=" + filled +
                '}';
    }
}
