package com.arobs.intenrship.lab3.ex2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TestCircle {
    private Scanner scanner = new Scanner(System.in);
    private Circle circle;

    public TestCircle() {
        circle = new Circle();
    }

    public TestCircle(double r) {
        circle = new Circle(r);
    }

    public TestCircle(String c) {
        circle = new Circle(c);
    }

    public TestCircle(double r, String c) {
        circle = new Circle(r, c);
    }

    public void displayCircleAttributes() {
        System.out.println(circle.toString());
        System.out.println("Area = " + circle.getArea());
    }

    public void redefineCircle() {
        System.out.println("\n\t Redefining circle: ");

        double newRadius = 0;
        String newColor;

        boolean validInput = false;
        while (!validInput) {
            System.out.println("\nRadius: ");
            try {
                double userInput = scanner.nextDouble();
                validInput = true;
                newRadius = userInput;
            } catch (InputMismatchException e) {
                System.out.println("That was not a number... Try again!");
                scanner.next();
            }
        }

        System.out.println("Color: ");
        newColor = scanner.next();

        circle.setRadius(newRadius);
        circle.setColor(newColor);

    }
}
