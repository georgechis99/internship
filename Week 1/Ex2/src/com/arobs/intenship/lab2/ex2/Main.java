package com.arobs.intenship.lab2.ex2;

public class Main {

    public static void main(String[] args) {

        //Exercise PrintNumberInWord (nested-if, switch-case): Write a program called PrintNumberInWord which prints “ONE”,
        // “TWO”,… , “NINE”, “OTHER” if the int variable “number” is 1, 2,… , 9, or other, respectively. Use (a) a “nested-if”
        // statement; (b) a “switch-case” statement.

        printNumberInWord1(-50);
        printNumberInWord2(4616);
        printNumberInWord1(5);
        printNumberInWord2(8);


    }

    public static void printNumberInWord1(int number) {

        if (number < 1 || number > 9) {
            System.out.println("OTHER");
        } else if (number == 1) {
            System.out.println("ONE");
        } else if (number == 2) {
            System.out.println("TWO");
        } else if (number == 3) {
            System.out.println("THREE");
        } else if (number == 4) {
            System.out.println("FOUR");
        } else if (number == 5) {
            System.out.println("FIVE");
        } else if (number == 6) {
            System.out.println("SIX");
        } else if (number == 7) {
            System.out.println("SEVEN");
        } else if (number == 8) {
            System.out.println("EIGHT");
        } else if (number == 9) {
            System.out.println("NINE");
        }
    }

    public static void printNumberInWord2(int number) {

        switch (number) {
            case 1: {
                System.out.println("ONE");
                break;
            }
            case 2: {
                System.out.println("TWO");
                break;
            }
            case 3: {
                System.out.println("THREE");
                break;
            }
            case 4: {
                System.out.println("FOUR");
                break;
            }
            case 5: {
                System.out.println("FIVE");
                break;
            }
            case 6: {
                System.out.println("SIX");
                break;
            }
            case 7: {
                System.out.println("SEVEN");
                break;
            }
            case 8: {
                System.out.println("EIGHT");
                break;
            }
            case 9: {
                System.out.println("NINE");
                break;
            }
            default: {
                System.out.println("OTHER");
                break;
            }

        }
    }


}
