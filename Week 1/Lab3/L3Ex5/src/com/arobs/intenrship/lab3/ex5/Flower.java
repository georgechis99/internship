package com.arobs.intenrship.lab3.ex5;

//Modify Flower class from Ciclul de viaţă al obiectelor so that it keeps track of the number of constructed object.
// Add a method which returns the number of constructed objects.
// Use 'static' variables and methods for implementing this task.

public class Flower {
    private static int flowerCount = 0;
    int petal;

    Flower() {
        flowerCount++;
        System.out.println("Flower has been created!");
    }

    public static void main(String[] args) {
        Flower[] garden = new Flower[5];
        for (int i = 0; i < 5; i++) {
            Flower f = new Flower();
            garden[i] = f;
        }

        displayNoOfFlowers();
    }

    public static void displayNoOfFlowers() {
        System.out.println("Up until now you have " + flowerCount + " flowers");
    }
}