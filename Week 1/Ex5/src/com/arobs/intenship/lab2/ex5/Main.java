package com.arobs.intenship.lab2.ex5;

public class Main {

    public static void main(String[] args) {

        //Write a program which generate a vector of 10 int elements, sort them using bubble sort method and then display the result.

        //generating random array of 10 elements
        int[] ourArray = new int[10];
        for (int i = 0; i < 10; i++) {
            ourArray[i] = (int) (Math.random() * 100);
        }

        System.out.print("Initial array: ");
        displayArray(ourArray);
        bubbleSort(ourArray);
        System.out.println();
        System.out.print("Sorted array: ");
        displayArray(ourArray);


    }

    //method to diaplsya an array
    public static void displayArray(int[] array) {
        int n = array.length; //store it here we'll be using it many times
        for (int i = 0; i < n; i++) {
            System.out.print(array[i] + "; ");
        }
    }

    //bubble sort
    public static void bubbleSort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int aux = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = aux;
                }
            }
        }
    }
}
