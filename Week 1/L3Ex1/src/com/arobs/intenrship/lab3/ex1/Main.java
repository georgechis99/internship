package com.arobs.intenrship.lab3.ex1;

public class Main {

    public static void main(String[] args) {

        //A class Robot contains:
        //
        //One instance variable 'x' (of type int) representing the position of robot;
        //One default constructor which initialize the value to 1;
        //One change(int k) method which add to the current robot x value to k (as long as k >= 1);
        //One toString() method which returns the position of robot;
        //Write a class which models the class Robot . Write a class TestRobot which test Robot class.

        TestRobot tr = new TestRobot();

        tr.displayRobotPosition();
        tr.changePositionAndDisplay(2);
        tr.changePositionAndDisplay(10);
        tr.displayPositionHistory();

        tr.goToPreviousPosition();
        tr.displayPositionHistory();

        tr.goToPreviousPosition();
        tr.displayPositionHistory();

        tr.goToPreviousPosition();
        tr.displayPositionHistory();

        tr.goToPreviousPosition(5);
        tr.displayPositionHistory();

    }
}
