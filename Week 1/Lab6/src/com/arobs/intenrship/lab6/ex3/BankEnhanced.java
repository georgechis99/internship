package com.arobs.intenrship.lab6.ex3;

import com.arobs.intenrship.lab6.ex1.BankAccount;

import java.util.*;

public class BankEnhanced {
    private TreeSet<BankAccountEnhanced> accounts;

    public BankEnhanced() {
        accounts = new TreeSet<>(); //10 initial elements reserved in memory
    }

    public void addAccount(String owner, double balance) {
        BankAccountEnhanced newBankAccount = new BankAccountEnhanced(owner, balance);
        try {
            accounts.add(newBankAccount);
        } catch (NullPointerException e) {
            System.out.println("TreeSet does not accept 'null'");
        }
    }

    public void addAccount(BankAccountEnhanced bankAccount) {
        try {
            accounts.add(bankAccount);
        } catch (NullPointerException e) {
            System.out.println("TreeSet does not accept 'null'");
        }
    }

    public void printAccounts() {
        for (BankAccountEnhanced bankAccount : accounts) {
            System.out.println(bankAccount.toString());
        }
    }

    public void printAccounts(double minBalance, double maxBalance) {
        for (BankAccountEnhanced bankAccount : accounts) {
            double balance = bankAccount.getBalance();
            if (balance > minBalance && balance < maxBalance) {
                System.out.println(bankAccount.toString());
            }
        }
    }

    public BankAccountEnhanced getAccount(String owner) {
        for (BankAccountEnhanced bankAccount : accounts) {
            if (bankAccount.getOwner() != null && bankAccount.getOwner().equals(owner)) {
                return bankAccount;
            }
        }
        return null;
    }

    public TreeSet<BankAccountEnhanced> getAllAccounts() {
        return accounts;
    }
}
