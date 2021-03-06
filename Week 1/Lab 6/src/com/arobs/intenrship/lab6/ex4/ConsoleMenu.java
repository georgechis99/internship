package com.arobs.intenrship.lab6.ex4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class ConsoleMenu {
    private static Dictionary dictionary = new Dictionary();
    private static Scanner scanner = new Scanner(System.in);
    private static boolean userQuits = false;

    public static Scanner getScanner() {
        return scanner;
    }

    public static void main(String[] args) {
        dictionary.addWord("Apple","Major tech product manufacturer company");
        dictionary.addWord("apple","Just a fruit");
        dictionary.addWord("preposterous","Contrary to reason or common sense; utterly absurd or ridiculous.");


        while (!userQuits) {
            printMainMenu();
            boolean validInput = false;
            while (!validInput) {
                int integerKeyPressed = 0;
                String keyPressed = scanner.next();
                try {
                    integerKeyPressed = Integer.parseInt(keyPressed);
                } catch (NumberFormatException e) {
                    System.out.println("\n You pressed a wrong key");
                }

                if(integerKeyPressed != 0){
                    validInput = true;
                    executeOption(integerKeyPressed);
                }
            }

        }
    }

    public static void printMainMenu() {
        System.out.println("Welcome to THE DICTIONARY! Press: \n" +
                "1 : To add a word \n" +
                "2 : To get a definition of a word \n" +
                "3 : To display all the words \n" +
                "4 : To display all the definitions \n" +
                "5 : To quit");
    }

    public static void executeOption(int input){
        switch (input){
            case 1:
                userAddsWord();
                break;
            case 2:
                userGetsDefinition();
                break;
            case 3:
                userGetsAllWords();
                break;
            case 4:
                userGetsAllDefinitions();
                break;
            case 5:
                userQuits = true;
                break;
            default:
                break;
        }
    }

    public static void userAddsWord(){
        Scanner scanner = getScanner();
        System.out.print("\n Enter a word: ");
        String inputWord = scanner.nextLine();
        System.out.print("\n Enter definition for \"" + inputWord + "\": ");
        String inputDefinition = scanner.nextLine();
        dictionary.addWord(inputWord,inputDefinition);
        System.out.println("Word added successfully! \n");
    }

    public static void userGetsDefinition(){
        Scanner scanner = getScanner();
        System.out.print("\n Enter the word whose definition you want to know: ");
        String inputWord = scanner.nextLine();
        Word word = new Word(inputWord);
        Definition definition = dictionary.getDefinition(word);
        String definitionOutput = definition.getDescription();
        System.out.println(inputWord + " : " + definitionOutput);
    }

    public static void userGetsAllWords(){
        Set<Word> allWords = dictionary.getAllWords();
        for(Word word : allWords){
            System.out.println(word.getName());
        }
    }

    public static void userGetsAllDefinitions(){
        List<Definition> allDefinitions = dictionary.getAllDefinitions();
        for(Definition definition : allDefinitions){
            System.out.println(definition.getDescription());
        }
    }
}


