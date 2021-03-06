package com.arobs.intenrship.lab6.ex1;

import com.arobs.intenrship.lab6.ex2.Bank;

import java.util.Comparator;
import java.util.List;

public class TestBankAccount {

    public static void main(String[] args) {
        BankAccount b1 = new BankAccount("Chis George", 500);
        BankAccount b2 = new BankAccount("Tiger Woods", 5000);
        BankAccount b3 = new BankAccount("Tiger Woods", 5000);
        BankAccount b4 = new BankAccount("Chis George", 999);

        b1.withdraw(100);
        b1.withdraw(900);

        b1.deposit(100);

        System.out.println(b1.equals(b2));
        System.out.println(b1.equals(b4));
        System.out.println(b2.equals(b3));

        System.out.println();

        System.out.println((b1.hashCode() == b2.hashCode()) + "\n");
        System.out.println((b1.hashCode() == b4.hashCode()) + "\n");
        System.out.println((b2.hashCode() == b3.hashCode()) + "\n");

        Bank bank1 = new Bank();
        bank1.addAccount(b1);
        bank1.addAccount(b2);
        bank1.addAccount(b3);
        bank1.addAccount(b4);
        bank1.addAccount("Richest Man", 1000000);
        bank1.addAccount("Poor Man", 0.1);
        bank1.addAccount("John Mack", 235);
        bank1.addAccount("Omar White", 852.8);
        bank1.addAccount("Jack Slade", 852.95);

        System.out.println("Sorted by balance: ");
        bank1.sortAccountsByBalance();
        bank1.printAccounts();

        System.out.println();
        System.out.println("Sorted by balance with range $300-$1000: ");
        bank1.printAccounts(300, 1000);

        if (bank1.getAllAccounts() != null) {
            List<BankAccount> allAccounts = bank1.getAllAccounts();
            allAccounts.sort(new Comparator<BankAccount>() {
                @Override
                public int compare(BankAccount o1, BankAccount o2) {
                    return o1.getOwner().compareTo(o2.getOwner());
                }
            });

            System.out.println();
            System.out.println("All acounts sorted alphabetically: ");
            bank1.printAccounts();
        } else {
            System.out.println("This bank hasn't got clients yet...");
        }

    }
}
