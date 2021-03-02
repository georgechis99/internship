package com.arobs.intenrship.lab4.ex4;

import com.arobs.intenrship.lab4.ex2.Author;

//Modify the Book class from previous exercise to support one or more authors by changing the instance variable authors to an Author array. Reuse the Author class written earlier.
//
//Notes:
//
//The constructors take an array of Author (i.e., Author[]), instead of an Author instance.
//The toString() method shall return “book-name by n authors”, where n is the number of authors.
//A new method printAuthors() to print the names of all the authors.
//You shall re-use the Author class written earlier.

public class BookEnhanced {
    private final String name;
    private final Author[] authors;
    private double price;
    private int qtyInStock = 0;

    public BookEnhanced(String name, Author[] authors, double price) {
        this.name = name;
        this.authors = authors;
        this.price = price;
    }

    public BookEnhanced(String name, Author[] authors, double price, int qtyInStock) {
        this.name = name;
        this.authors = authors;
        this.price = price;
        this.qtyInStock = qtyInStock;
    }

    public String getName() {
        return name;
    }

    public Author[] getAuthors() {
        return authors;
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
        return "\"" + name + "\"" + " by " + authors.length + " authors";
    }

    public void printAuthors() {
        System.out.print("The auhors of \"" + name + "\" are: ");
        for (Author author : authors) {
            System.out.print(author.getName() + ", ");
        }
        System.out.println("\n");
    }
}
