package com.arobs.intenrship.lab7.ex1;

public class TemperatureException extends Exception {
    private int t;

    public TemperatureException(int t, String msg) {
        super(msg);
        this.t = t;
    }

    int getTemp() {
        return t;
    }
}
