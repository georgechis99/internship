package com.arobs.internship.ex7;

import java.util.Scanner;

public class Game {
    private static Scanner scanner = new Scanner(System.in);
    private static boolean isOver;
    private static int roundNumber;
    private static int randomNumber;

    public static void setIsOver(boolean isOver) {
        Game.isOver = isOver;
    }

    public static int getRandomNumber() {
        return randomNumber;
    }

    public Game() {
        isOver = false;
        roundNumber = 1;
        randomNumber = (int) (Math.random() * 10);
    }

    public void startGame() {
        System.out.println("\n\t\t===GUESS THE NUMBER===");

        boolean validInput = false;
        while (!validInput) {
            System.out.println("\nPress 'g' to generate a random number between 0 and 50 or 'q' to quit game");
            String userInput = scanner.next();
            switch (userInput) {
                case "q": {
                    validInput = true;
                    Game.setIsOver(true);
                    break;
                }
                case "g": {
                    validInput = true;
                    break;
                }
                default: {
                    System.out.println("Wrong input, try again please!");
                    break;
                }
            }
        }


        while (!isOver && roundNumber <= 3) {
            Round round = new Round();
            round.startRound(roundNumber);
            roundNumber++;
        }
        if (roundNumber > 3) {
            System.out.println("\nSorry, you had 3 tries...GAME OVER");
        } else {
            System.out.println("\nSorry to see you go...");
        }

    }
}
    

