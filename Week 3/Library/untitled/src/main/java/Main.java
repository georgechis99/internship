import model.Author;
import model.Book;
import model.DataSource;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException {
        Scanner scanner = new Scanner(System.in);
        if (!DataSource.getInstance().open()) {
            System.out.println("Error connecting to database");
        }


        System.out.println("All authors:");
        List<Author> allAuthors = DataSource.getInstance().queryAllAuthors();
        if (allAuthors != null) {
            for (Author author : allAuthors) {
                System.out.println(author.getId() + " : " + author.getName());
            }
        } else {
            System.out.println("Artists table empty...");
        }

//        System.out.println();
//        System.out.println("Enter name identifier for authors:");
//        String nameIdentifierForAuthors = scanner.nextLine();
//        List<Author> authorsByName = DataSource.getInstance().queryAuthorsByName(nameIdentifierForAuthors);
//        if(authorsByName != null){
//            System.out.println("Matches found for \"" + nameIdentifierForAuthors + "\" :");
//            for(Author author : authorsByName){
//                System.out.println(author.getId() + " : "  +author.getName());
//            }
//            if(authorsByName.isEmpty()){
//                System.out.println("No matches found for \"" + nameIdentifierForAuthors + "\"...");
//            }
//        }else{
//            System.out.println("Artists by name empty...");
//        }

        System.out.println();
        System.out.println("Author count = " + DataSource.getInstance().countAllAuthors());

//        System.out.println();
//        System.out.println("Enter name identifier for books:");
//        String titleIdentifierForBooks = scanner.nextLine();
//            List<Book> booksByName = DataSource.getInstance().queryBooksByTitle(titleIdentifierForBooks);
//        if (booksByName != null) {
//            System.out.println("Matches found for \"" + titleIdentifierForBooks + "\" :");
//            for (Book book : booksByName) {
//                System.out.println(book.getId() + " : " + book.getTitle());
//            }
//            if (booksByName.isEmpty()) {
//                System.out.println("No matches found for \"" + titleIdentifierForBooks + "\"...");
//            }
//        } else {
//            System.out.println("Books by title empty...");
//        }

//        System.out.println();
//        System.out.println("Filter books by price:");
//        List<Book> booksByPrice = null;
//        boolean validInput = false;
//        int numericValue;
//        while (!validInput) {
//            System.out.println("lower than : PRESS L / higher than : PRESS H");
//            String lowerOrHigher = scanner.nextLine().toUpperCase();
//            switch (lowerOrHigher) {
//                case "L":
//                    validInput = true;
//                    System.out.println("Price lower than... (ENTER NUMERIC VALUE):");
//                    numericValue = scanner.nextInt();
//                    booksByPrice = DataSource.getInstance().filterBooksByPrice(numericValue, true);
//                    break;
//                case "H":
//                    validInput = true;
//                    System.out.println("Price higher than... (ENTER NUMERIC VALUE):");
//                    numericValue = scanner.nextInt();
//                    booksByPrice = DataSource.getInstance().filterBooksByPrice(numericValue, false);
//                    break;
//                default:
//                    System.out.println("Invalid input...");
//                    break;
//            }
//        }
//        if (booksByPrice != null) {
//            System.out.println("Matches found:");
//            for (Book book : booksByPrice) {
//                System.out.println(book.getId() + " : " + book.getTitle() + " : " + book.getPrice());
//            }
//            if (booksByPrice.isEmpty()) {
//                System.out.println("No matches found...");
//            }
//        } else {
//            System.out.println("Books by price empty...");
//        }

        System.out.println();
        System.out.println("Books ordered asc by price:");
        List<Book> booksAscPrice = DataSource.getInstance().orderBooksByPrice(true);
        if (booksAscPrice != null) {
            System.out.println("Matches found:");
            for (Book book : booksAscPrice) {
                System.out.println(book.getId() + " : " + book.getTitle() + " : " + book.getPrice());
            }
            if (booksAscPrice.isEmpty()) {
                System.out.println("No matches found...");
            }
        } else {
            System.out.println("Books asc by price empty...");
        }

        System.out.println();
        System.out.println("Books ordered desc by price:");
        List<Book> booksDescPrice = DataSource.getInstance().orderBooksByPrice(false);
        if (booksDescPrice != null) {
            System.out.println("Matches found:");
            for (Book book : booksDescPrice) {
                System.out.println(book.getId() + " : " + book.getTitle() + " : " + book.getPrice());
            }
            if (booksDescPrice.isEmpty()) {
                System.out.println("No matches found...");
            }
        } else {
            System.out.println("Books desc by price empty...");
        }

        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");

        try {
            java.util.Date utilDate = format.parse("2018/04/13");
            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
            DataSource.getInstance().insertBook("Robert Greene", "The 50 Laws Of Power", sqlDate, 64.99f);
        } catch (ParseException e) {
            e.printStackTrace();
        }


    }
}
