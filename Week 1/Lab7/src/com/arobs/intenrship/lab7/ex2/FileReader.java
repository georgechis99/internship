package com.arobs.intenrship.lab7.ex2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileReader {
    private static Scanner scanner;
    private static long charCount;

    public FileReader() {
        charCount = 0;
    }

    public long countCharOccurrence(File myTextFile, char givenChar) {
        try {
            scanner = new Scanner(myTextFile);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                long lineCharCount = line.chars().filter(ch -> ch == givenChar).count();
                incrementCharCount(lineCharCount);
            }
            return charCount;
        } catch (FileNotFoundException e) {
            System.out.println(myTextFile.getName() + " not found!");
        }
        return charCount;
    }

    public static void incrementCharCount(long intermediateCount) {
        charCount += intermediateCount;
    }

}
