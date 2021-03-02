package com.arobs.intenrship.lab3.ex3;

public class Author {
    private String name;
    private String email;
    private char gender;

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

    public static boolean verifyGender(char gender) {
        return gender == 'm' || gender == 'f';
    }

    public static boolean verifyEmail(String email) {
        if (email.contains("@")) {
            int lastAtOccurence = 0;
            for (int i = 0; i < email.length(); i++) {
                if (email.charAt(i) == '@') {
                    lastAtOccurence = i;
                }
            }

            int lastDotOccurence = 0;
            if (email.contains(".")) {
                for (int i = 0; i < email.length(); i++) {
                    if (email.charAt(i) == '.') {
                        lastDotOccurence = i;
                    }
                }
            } else {
                return false;
            }

            return lastAtOccurence < lastDotOccurence;
        }
        return false;
    }
}
