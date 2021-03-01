package com.arobs.intenship.lab2.ex6;

public class Main {

    public static void main(String[] args) {

        //Being given an int number N, compute N! using 2 methods:
        //
        //a non recursive method
        //a recursive method

        System.out.println(factorialNonRecursive(3));
        System.out.println(factorialRecursive(0));

    }

    //non-recursive method
    public static int factorialNonRecursive(int n) {
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    //using a recursive method
    public static int factorialRecursive(int n) {
        if (n == 0) {
            return 1;
        } else if (n == 1) {
            return 1;
        } else {
            return n * factorialRecursive(n - 1);
        }
    }
}
