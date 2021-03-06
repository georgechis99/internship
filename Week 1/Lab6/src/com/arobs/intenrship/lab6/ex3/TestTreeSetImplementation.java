package com.arobs.intenrship.lab6.ex3;

import java.util.TreeSet;

public class TestTreeSetImplementation {

    public static void main(String[] args) {
        BankAccountEnhanced b0 = new BankAccountEnhanced("Jones",100.50);
        BankAccountEnhanced b1 = new BankAccountEnhanced("Abernathy",100.50);
        BankAccountEnhanced b2 = new BankAccountEnhanced("Callahan",52.75);
        BankAccountEnhanced b3 = new BankAccountEnhanced("Doolittle",258.88);
        BankAccountEnhanced b4 = new BankAccountEnhanced("West",1550);
        BankAccountEnhanced b5 = new BankAccountEnhanced("West",1003.87);
        BankAccountEnhanced b6 = new BankAccountEnhanced("Figg",235.4);
        BankAccountEnhanced b7 = new BankAccountEnhanced("Lucas",235.4);
        BankAccountEnhanced b8 = new BankAccountEnhanced("Lucas",235.4);

        BankEnhanced bank1 = new BankEnhanced();

        bank1.addAccount(b0);
        bank1.addAccount(b1);
        bank1.addAccount(b2);
        bank1.addAccount(b3);
        bank1.addAccount(b4);
        bank1.addAccount(b5);
        bank1.addAccount(b6);
        bank1.addAccount(b7);
        bank1.addAccount(b8);
        bank1.addAccount(null);

        bank1.printAccounts();
    }
}
