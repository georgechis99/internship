package com.arobs.intenrship.lab4.ex3;

import com.arobs.intenrship.lab4.ex2.Author;

//A class called Book is designed as shown in the class diagram. It contains:
//
//Four private instance variables: name (String), author (of the class Author you have just created, assume that each book has one and only one author), price (double), and qtyInStock (int);
//Two constructors:
//public Book (String name, Author author, double price) {…}
//public Book (String name, Author author, double price,
//int qtyInStock) {…}
//public methods getName(), getAuthor(), getPrice(), setPrice(), getQtyInStock(), setQtyInStock().
//toString() that returns “'book-name' by author-name (gender) at email”.
//(Take note that the Author's toString() method returns “author-name (gender) at email”.)

public class Book {
    private final String name;
    private final Author author;
    private double price;
    private int qtyInStock = 0;

    public Book(String name, Author author, double price) {
        this.name = name;
        this.author = author;
        this.price = price;
    }

    public Book(String name, Author author, double price, int qtyInStock) {
        this.name = name;
        this.author = author;
        this.price = price;
        this.qtyInStock = qtyInStock;
    }

    public String getName() {
        return name;
    }

    public Author getAuthor() {
        return author;
    }

    public double getPrice() {
        return price;
    }

    public int getQtyInStock() {
        return qtyInStock;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setQtyInStock(int qtyInStock) {
        this.qtyInStock = qtyInStock;
    }

    @Override
    public String toString() {
        return "\"" + name + "\"" + " by " + author.toString();
    }
}
