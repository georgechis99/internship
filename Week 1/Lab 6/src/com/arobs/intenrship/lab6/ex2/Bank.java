package com.arobs.intenrship.lab6.ex2;

import com.arobs.intenrship.lab6.ex1.BankAccount;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Bank {
    private List<BankAccount> accounts;

    public Bank() {
        accounts = new ArrayList<>(); //10 initial elements reserved in memory
    }

    public void addAccount(String owner, double balance) {
        BankAccount newBankAccount = new BankAccount(owner, balance);
        accounts.add(newBankAccount);
    }

    public void addAccount(BankAccount bankAccount) {
        accounts.add(bankAccount);
    }

    public void sortAccountsByBalance() {
        accounts.sort(Comparator.comparingDouble(BankAccount::getBalance));
    }

    public void printAccounts() {
        for (BankAccount bankAccount : accounts) {
            System.out.println(bankAccount.toString());
        }
    }

    public void printAccounts(double minBalance, double maxBalance) {
        for (BankAccount bankAccount : accounts) {
            double balance = bankAccount.getBalance();
            if (balance > minBalance && balance < maxBalance) {
                System.out.println(bankAccount.toString());
            }
        }
    }

    public BankAccount getAccount(String owner){
        for(BankAccount bankAccount : accounts){
            if(bankAccount.getOwner() != null && bankAccount.getOwner().equals(owner)){
                return bankAccount;
            }
        }
        return null;
    }

    public List<BankAccount> getAllAccounts(){
        return accounts;
    }
}
