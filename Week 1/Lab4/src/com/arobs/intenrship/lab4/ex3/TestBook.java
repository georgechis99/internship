package com.arobs.intenrship.lab4.ex3;

import com.arobs.intenrship.lab4.ex2.Author;

public class TestBook {

    public static void main(String[] args) {
        Author author1 = new Author("Ryan Holiday", "ryan@holiday.com", 'm');
        Author author2 = new Author("Robert Greene", "robert@greene.com", 'm');

        Book book1 = new Book("Ego is the enemy", author1, 35.50, 100);
        Book book2 = new Book("Mastery", author2, 70.25, 50);

        System.out.println("Book 1 info from getters: ");
        System.out.println(book1.getName() + " " + book1.getAuthor() + " " + book1.getPrice() + " " +
                book1.getQtyInStock() + "\n");

        System.out.println("Book 2 info from getters: ");
        System.out.println(book2.getName() + " " + book2.getAuthor() + " " + book2.getPrice() + " " +
                book2.getQtyInStock() + "\n");

        book1.setPrice(45);
        book1.setQtyInStock(25);
        System.out.println("Book 1 info from toString(): " + book1.toString() + "\n");

        book1.setPrice(60);
        book1.setQtyInStock(30);
        System.out.println("Book 2 info from toString(): " + book2.toString() + "\n");

    }

}
