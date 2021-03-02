package com.arobs.intenrship.lab3.ex4;

public class MyPoint {
    private int x;
    private int y;

    public MyPoint() {
        x = 0;
        y = 0;
    }

    public MyPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setXY(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    public double distance(int x, int y) {
        int xa = this.x;
        int ya = this.y;

        return Math.sqrt(Math.pow(xa - x, 2) + Math.pow(ya - y, 2));
    }

    public double distance(MyPoint another) {
        int xa = this.x;
        int ya = this.y;

        int xb = another.getX();
        int yb = another.getY();

        return Math.sqrt(Math.pow(xa - xb, 2) + Math.pow(ya - yb, 2));
    }
}
