package com.arobs.internship.ex7;

import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static boolean gameOver;
    private static int roundCount;

    public static void main(String[] args) {

        //Write a “Guess the number” game in Java. Program will generate a random number and will ask user to guess it.
        // If user guess the number program will stop. If user do not guess it program will display:
        // 'Wrong answer, your number it too high' or 'Wrong answer, your number is too low'.
        // Program will allow user maximum 3 retries after which will stop with message 'You lost'.

        Game game = new Game();
        game.startGame();

    }
}
