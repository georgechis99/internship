package com.arobs.intenrship.lab7.ex4;

import java.io.Serializable;

public class Car implements Serializable {
    private static final long serialVersionUID = 1234566789L;
    private String model;
    private double price;

    public Car(String model, double price) {
        this.model = model;
        this.price = price;
    }

    public String getModel() {
        return model;
    }

    public double getPrice() {
        return price;
    }
}
