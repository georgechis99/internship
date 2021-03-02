package com.arobs.intenrship.lab4.ex4;

import com.arobs.intenrship.lab4.ex2.Author;

public class TestBookEnhanced {

    public static void main(String[] args) {
        BookEnhanced bookEnhanced1 = new BookEnhanced("The 50 Laws of Power",
                new Author[]{new Author("Robert Greene", "rob@greene.com", 'm'),
                        new Author("Curtis Jackson", "50cent@jackson.com", 'm')},
                50.50,100);

        BookEnhanced bookEnhanced2 = new BookEnhanced("Meditations",
                new Author[]{new Author("Marcus Aurelius", "hail@caesar.rome", 'm'),
                        new Author("Lucius Senecca", "senecca@me.com", 'm')},
                50.50,100);

        System.out.println("Book 1 info from toString(): " + bookEnhanced1.toString() + "\n");
        System.out.println("Book 2 info from toString(): " + bookEnhanced2.toString() + "\n");

        bookEnhanced1.printAuthors();
        bookEnhanced2.printAuthors();

    }
}
