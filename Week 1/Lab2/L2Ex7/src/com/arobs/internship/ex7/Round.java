package com.arobs.internship.ex7;

import java.util.Scanner;

public class Round {
    private final Scanner scanner = new Scanner(System.in);
    private static int userNumberInput;


    public void startRound(int roundNumber) {
        System.out.println("\n*ROUND " + roundNumber + "*");

        if (guessedRight(scanner, Game.getRandomNumber())) {
            System.out.println("YOU GUESSED RIGHT! CONGRATS!");
            Game.setIsOver(true);
        }

    }

    public static boolean guessedRight(Scanner scanner, int number) {
        boolean validInput = false;

        while (!validInput) {
            System.out.println("Guess the number between 0 and 10: ");
            String userInput = scanner.next();
            try {
                userNumberInput = Integer.parseInt(userInput.trim());
                if(userNumberInput > 10 || userNumberInput < 0){
                    System.out.println("Number not in the range please try again!");
                } else {
                    validInput = true;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input, try again!");
            }
        }

        if (userNumberInput == number) {
            return true;
        } else {
            if (userNumberInput > number) {
                System.out.println("Wrong answer, your number it too high");
            } else {
                System.out.println("Wrong answer, your number it too low");
            }
            return false;
        }
    }


}
