package com.arobs.intenrship.lab6.ex3;

import com.arobs.intenrship.lab6.ex1.BankAccount;

import java.util.Comparator;
import java.util.Objects;

public class BankAccountEnhanced implements Comparable<BankAccountEnhanced> {
    private final String owner;
    private double balance;

    public BankAccountEnhanced() {
        owner = "default";
        balance = 0.0;
    }

    public BankAccountEnhanced(String owner, double balance) {
        this.owner = owner;
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public String getOwner() {
        return owner;
    }

    public void withdraw(double ammount) {
        if (balance >= ammount) {
            balance -= ammount;
            System.out.println("Successfully withdrew $" + ammount);
        } else {
            System.out.println("Not sufficient funds");
        }
    }

    public void deposit(double ammount) {
        balance += ammount;
        System.out.println("Successfully deposited $" + ammount);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BankAccountEnhanced that = (BankAccountEnhanced) o;
        return Double.compare(that.balance, balance) == 0 && owner.equals(that.owner);
    }

    @Override
    public int hashCode() {
        return Objects.hash(owner, balance);
    }

    @Override
    public String toString() {
        return "BankAccountEnhanced{" +
                "owner='" + owner + '\'' +
                ", balance= $" + balance +
                '}';
    }

    @Override
    public int compareTo(BankAccountEnhanced other) {
        int comp = Double.compare(this.balance,  other.balance);
        if (comp != 0) {
            return comp;
        }
        return this.owner.compareTo(other.owner);
    }
}