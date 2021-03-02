package com.arobs.intenship.lab2.ex1;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        //Write a program which reads 2 numbers from keyboard and display the maximum between them.

        Scanner scanner = new Scanner(System.in);

        //user input
        System.out.print("Enter first number: ");
        int firstNumber = scanner.nextInt();
        System.out.print("Enter second number: ");
        int secondNumber = scanner.nextInt();

        //calling the static method
        max(firstNumber, secondNumber);
    }

    //static method to compute the maximum between two numbers
    public static void max(int a, int b) {
        if (a == b) {
            System.out.println(a + " and " + b + " are equal");
        } else {
            System.out.print("The maximum number is: ");
            if (a > b) {
                System.out.print(a);
            } else {
                System.out.print(b);
            }
        }
    }
}
