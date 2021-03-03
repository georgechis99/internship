package com.arobs.intenrship.lab3.ex1;

import java.util.ArrayList;

public class TestRobot {
    private Robot robotModel;
    private static ArrayList<Integer> positionHistory;

    public TestRobot() {
        robotModel = new Robot();
        positionHistory = new ArrayList<>();
        addPositionToHistory(1);
    }

    public void displayRobotPosition() {
        System.out.println(robotModel.toString());
    }

    public void changePositionAndDisplay(int k) {
        robotModel.change(k);
        addPositionToHistory(k);
        System.out.println("New position is: ");
        displayRobotPosition();
    }

    public void addPositionToHistory(int k) {
        positionHistory.add(k);
    }

    public void displayPositionHistory() {
        System.out.println("Position history: " + positionHistory.toString());
    }

    public void goToPreviousPosition() {
        int previous = positionHistory.get(positionHistory.size() - 2);
        robotModel.change(previous);
        System.out.println("Went to previous position: " + robotModel.toString());
        addPositionToHistory(previous);
    }

    public void goToPreviousPosition(int n) {
        int previous = positionHistory.get(positionHistory.size() - 1 - n);
        robotModel.change(previous);
        System.out.println("Went to previous position: " + robotModel.toString());
        addPositionToHistory(previous);
    }

}
