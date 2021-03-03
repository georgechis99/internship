package com.arobs.intenship.lab2.ex3;

public class Main {

    public static void main(String[] args) {

        //Write a program which display prime numbers between A and B, where A and B are read from console.
        // Display also how many prime numbers have been found.
        primeNumbersInInterval(0, 10);

    }

    public static void primeNumbersInInterval(int a, int b) {
        System.out.print("The prime numbers between " + a + " and " + b + " are: ");
        int primeCounter = 0;
        if (a > b) {
            int aux = a;
            a = b;
            b = aux;
        }
        for (int i = a; i <= b; i++) {
            if (isPrime(i)) {
                primeCounter++;
                System.out.print(i + "; ");
            }
        }
        System.out.println();
        System.out.println("In total there were " + primeCounter + " prime numbers found.");
    }

    public static boolean isPrime(int number) {
        int divisorsCount = 0;
        int divisor = 2;
        while (divisor <= number / 2) {
            if (number % divisor == 0) {
                divisorsCount++;
            }
            divisor++;
        }

        if (divisorsCount == 0) {
            return true;
        } else {
            return false;
        }
    }
}
