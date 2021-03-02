package com.arobs.intenrship.lab4.ex2;

public class TestAuthor {

    public static void main(String[] args) {
        Author author1 = new Author("Ryan Holiday", "ryan@holiday.com", 'm');
        Author author2 = new Author("Robert Greene", "robert@greene.com", 'm');

        System.out.println("Author 1 info from getters: ");
        System.out.println(author1.getName() + " " + author1.getEmail() + " " + author1.getGender());

        author1.setEmail("ryanOfficial@goliday.com");
        System.out.println("Author 1 info from toString(): " + author1.toString() + "\n");

        System.out.println("Author 2 info from getters: ");
        System.out.println(author2.getName() + " " + author2.getEmail() + " " + author2.getGender());

        author2.setEmail("robOfficial@greene.com");
        System.out.println("Author 2 info from toString(): " + author2.toString() + "\n");
    }
}
