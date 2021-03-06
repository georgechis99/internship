package com.arobs.intenrship.lab7.ex1;

public class CoffeeTest {
    public static void main(String[] args) {
        CoffeeMaker mk = new CoffeeMaker();
        CoffeeDrinker d = new CoffeeDrinker();

        for (int i = 0; i < 15; i++) {
            try {
                Coffee c = mk.makeCoffee();
                try {
                    d.drinkCofee(c);
                } catch (TemperatureException e) {
                    System.out.println("Exception:" + e.getMessage() + " temp=" + e.getTemp());
                } catch (ConcentrationException e) {
                    System.out.println("Exception:" + e.getMessage() + " conc=" + e.getConc());
                } finally {
                    System.out.println("Throw the coffee cup.\n");
                }
            } catch (CoffeeNumberExceededException e) {
                System.out.println("Exception:" + e.getMessage());
            }

        }
    }
}
