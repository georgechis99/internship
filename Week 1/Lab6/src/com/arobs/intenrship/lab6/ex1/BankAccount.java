package com.arobs.intenrship.lab6.ex1;

public class BankAccount {
    private final String owner;
    private double balance;

    public BankAccount() {
        owner = "default";
        balance = 0.0;
    }

    public BankAccount(String owner, double balance) {
        this.owner = owner;
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public String getOwner() {
        return owner;
    }

    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Successfully withdrew $" + amount);
        } else {
            System.out.println("Not sufficient funds");
        }
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Successfully deposited $" + amount);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || (obj.getClass() != this.getClass())) {
            return false;
        }

        BankAccount ba = (BankAccount) obj;

        return this.owner.equals(ba.owner) && this.balance == ba.balance;
    }

    @Override
    public int hashCode() {
        System.out.println(this.owner.hashCode());
        return this.owner.hashCode() + (int) this.balance;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "owner='" + owner + '\'' +
                ", balance= $" + balance +
                '}';
    }
}
