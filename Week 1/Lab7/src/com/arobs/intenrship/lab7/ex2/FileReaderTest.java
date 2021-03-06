package com.arobs.intenrship.lab7.ex2;

import java.io.File;

public class FileReaderTest {

    public static void main(String[] args) {
        File file = new File("C:\\Users\\george.chis\\Desktop\\Internship\\homework\\Week 1\\Lab7\\src\\com\\arobs\\intenrship\\lab7\\ex2\\data.txt");
        FileReader reader = new FileReader();

        System.out.println("\"" + args[0].charAt(0) + "\"" + " appears in " + file.getName() + " " +
                reader.countCharOccurrence(file, args[0].charAt(0)) + " times");
    }
}
