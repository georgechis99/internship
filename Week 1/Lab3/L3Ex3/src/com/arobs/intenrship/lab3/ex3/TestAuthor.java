package com.arobs.intenrship.lab3.ex3;

import java.util.Scanner;

public class TestAuthor {
//    private static final Scanner scanner = new Scanner(System.in);
    private Author author;

    public void enlistAuhor() {
        Scanner scanner = new Scanner(System.in);
        String name = "", email = "";
        char gender = 'e';

        System.out.print("Name: ");
        name = scanner.nextLine();

        boolean validEmail = false;
        while (!validEmail) {
            System.out.print("Email: ");
            String emailInput = scanner.next();
            if (Author.verifyEmail(emailInput)) {
                validEmail = true;
                email = emailInput;
            } else {
                System.out.println("Invalid email format, try again");
            }
        }

        boolean validGender = false;
        while (!validGender) {
            System.out.print("Gender (m/f): ");
            char genderInput = scanner.next().charAt(0);
            if (Author.verifyGender(genderInput)) {
                validGender = true;
                gender = genderInput;
            } else {
                System.out.println("Invalid gender, please type 'm' or 'f'");
            }
        }

        if (!name.equals("") && !email.equals("") && gender != 'e') {
            System.out.println("Enlisted successfully!");
            author = new Author(name, email, gender);
        } else {
            System.out.println("There was some kind of input error, please try again");
        }
    }

    public void resetEmail() {
        Scanner scanner = new Scanner(System.in);
        String inputName, inputEmail = "";
        char inputGender = 'e';
        System.out.println("\nTo reset your email please enter your credentials:");
        System.out.print("\n\tName: ");

        scanner.next();
        inputName = scanner.nextLine();
        System.out.println(inputName); //debugging
        if (inputName.equals(author.getName())) {  //?? inputName is ""

            System.out.print("\n\tGender: ");
            inputGender = scanner.next().charAt(0);
            if (inputGender == author.getGender()) {

                System.out.println("\n\tEnter new email: ");
                boolean validEmail = false;
                while (!validEmail) {
                    System.out.print("Email: ");
                    inputEmail = scanner.next();
                    if (Author.verifyEmail(inputEmail)) {
                        validEmail = true;
                        author.setEmail(inputEmail);
                    } else {
                        System.out.println("Invalid email format, try again");
                    }
                }
            } else {
                System.out.println("Invalid gender!");
            }
        } else {
            System.out.println("Invalid name!");
        }
    }

    public void displayCredentials() {
        System.out.println(author.toString());
    }
}
