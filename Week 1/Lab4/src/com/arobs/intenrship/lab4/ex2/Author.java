package com.arobs.intenrship.lab4.ex2;

//A class called Author is designed as shown in the class diagram. It contains:
//
//Three private instance variables: name (String), email (String), and gender (char of either 'm' or 'f');
//One constructor to initialize the name, email and gender with the given values;
//public Author (String name, String email, char gender) {……}
//(There is no default constructor for Author, as there are no defaults for name, email and gender.)
//public getters/setters: getName(), getEmail(), setEmail(), and getGender();
//(There are no setters for name and gender, as these attributes cannot be changed.)
//A toString() method that returns “author-name (gender) at email”

public class Author {
    private final String name;
    private String email;
    private final char gender;

    public Author(String name, String email, char gender) {
        this.name = name;
        this.email = email;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public char getGender() {
        return gender;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return name + " (" + gender + ") at " + email;
    }
}
