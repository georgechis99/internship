package com.arobs.intenrship.lab3.ex1;

public class Robot {
    private int x;

    public Robot() {
        x = 1;
    }

    public void change(int k) {
        if (k >= 1) {
            x = k;
        } else {
            System.out.println("k has to be >= 1");
        }
    }

    @Override
    public String toString() {
        return "Robot{" +
                "x=" + x +
                '}';
    }
}
