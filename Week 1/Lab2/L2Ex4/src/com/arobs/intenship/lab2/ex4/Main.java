package com.arobs.intenship.lab2.ex4;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        //Giving a vector of N elements, display the maximum element in the vector.
        int[] ourVector = {1, 66, 765, 4, -8, 888, -15, 0, 0, 88, 67, 543, 7, 8, 9};

        Arrays.sort(ourVector);
        System.out.println("The maximum value in the array is: " + ourVector[ourVector.length - 1]);

    }
}
