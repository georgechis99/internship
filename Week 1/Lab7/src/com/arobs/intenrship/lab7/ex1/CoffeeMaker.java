package com.arobs.intenrship.lab7.ex1;

public class CoffeeMaker {
    public static final int maxCoffeeCount = 10;
    private static int coffeeCount;

    public CoffeeMaker() {
        coffeeCount = 0;
    }

    public Coffee makeCoffee() throws CoffeeNumberExceededException {
        System.out.println("Making coffee #" + coffeeCount);
        int t = (int) (Math.random() * 100);
        int c = (int) (Math.random() * 100);
        Coffee coffee = new Coffee(t, c);
        coffeeCount++;
        if (coffeeCount > maxCoffeeCount) {
            throw new CoffeeNumberExceededException("Coffee number exceeded! Refill CoffeeMaker...");
        }
        return coffee;
    }
}
