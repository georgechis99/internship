package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DataSource {
    //Connection Strings and DB Credentials
    public static final String DB_URL = "jdbc:mysql://localhost:3306";
    public static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    public static final String USER = "root";
    public static final String PASS = "12345678";

    //Frequently used queries stored in constants
    //Tables and Columns
    public static final String DB_NAME = "library";

    public static final String TABLE_AUTHORS = "author";
    public static final String COLUMN_AUTHOR_ID = "id";
    public static final String COLUMN_AUTHOR_NAME = "name";

    public static final String TABLE_BOOKS = "book";
    public static final String COLUMN_BOOK_ID = "id";
    public static final String COLUMN_BOOK_AUTHOR_ID = "author_id";
    public static final String COLUMN_BOOK_TITLE = "title";
    public static final String COLUMN_BOOK_PUBLISH_DATE = "publish_date";
    public static final String COLUMN_BOOK_PRICE = "price";

    //Prepared Queries
    //Author
    public static final String SELECT_AUTHORS = "SELECT * FROM " + TABLE_AUTHORS;

    public static final String SELECT_AUTHORS_BY_NAME = "SELECT * FROM " + TABLE_AUTHORS +
            " WHERE " + COLUMN_AUTHOR_NAME + " LIKE ?";

    public static final String COUNT_AUTHORS = "SELECT COUNT(*) FROM " + TABLE_AUTHORS;

    //Book
    public static final String SELECT_BOOKS_BY_TITLE = "SELECT * FROM " + TABLE_BOOKS +
            " WHERE " + COLUMN_BOOK_TITLE + " LIKE ?";

    public static final String SELECT_BOOKS_BY_PRICE_LOWER_THAN = "SELECT * FROM " + TABLE_BOOKS +
            " WHERE " + COLUMN_BOOK_PRICE + " < ?";

    public static final String SELECT_BOOKS_BY_PRICE_HIGHER_THAN = "SELECT * FROM " + TABLE_BOOKS +
            " WHERE " + COLUMN_BOOK_PRICE + " > ?";

    public static final String SELECT_BOOKS_ORDER_BY_PRICE_LOW_TO_HIGH = "SELECT * FROM " + TABLE_BOOKS +
            " ORDER BY " + COLUMN_BOOK_PRICE + " ASC";

    public static final String SELECT_BOOKS_ORDER_BY_PRICE_HIGH_TO_LOW = "SELECT * FROM " + TABLE_BOOKS +
            " ORDER BY " + COLUMN_BOOK_PRICE + " DESC";

    //Author + Book
    public static final String QUERY_AUTHORS = "SELECT " + COLUMN_AUTHOR_ID + " FROM " + TABLE_AUTHORS + " WHERE " +
            COLUMN_AUTHOR_NAME + " = ?";

    public static final String QUERY_BOOKS = "SELECT " + COLUMN_BOOK_ID + " FROM " + TABLE_BOOKS + " WHERE " +
            COLUMN_BOOK_TITLE + " = ?";

    public static final String INSERT_AUTHOR = "INSERT INTO " + TABLE_AUTHORS +
            "(" + COLUMN_AUTHOR_NAME + ") VALUES(?)";

    public static final String INSERT_BOOK = "INSERT INTO " + TABLE_BOOKS +
            "(" + COLUMN_BOOK_AUTHOR_ID + " , " + COLUMN_BOOK_TITLE + " , " + COLUMN_BOOK_PUBLISH_DATE + " , " + COLUMN_BOOK_PRICE +
            ") VALUES(? , ? , ? , ?)";

    public static final String DELETE_BOOK = "DELETE FROM " + TABLE_BOOKS + " WHERE " + COLUMN_BOOK_TITLE + " = ?";

    //PreparedStatements
    private PreparedStatement queryAuthorsByNamePreparedStatement;
    private PreparedStatement queryBooksByTitlePreparedStatement;
    private PreparedStatement filterBooksByPrice;
    private PreparedStatement orderBooksByPrice;
    private PreparedStatement queryAuthors;
    private PreparedStatement insertIntoAuthors;
    private PreparedStatement queryBooks;
    private PreparedStatement insertIntoBooks;
    private PreparedStatement deleteFromBooks;

    private Connection conn;

    private static final DataSource instance = new DataSource();

    private DataSource() {

    }

    public static DataSource getInstance() {
        return instance;
    }

    public boolean open() {
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            try (Statement statement = conn.createStatement()) {
                statement.execute("USE " + DB_NAME);
            }
            System.out.println("Connection successful!");
            return true;
        } catch (ClassNotFoundException e) {
            System.out.println("ClassNotFoundException caught...");
            return false;
        } catch (SQLException e) {
            System.out.println("Couldn't connect to database...");
            return false;
        }
    }

    public List<Author> queryAllAuthors() {
        try (Statement statement = conn.createStatement();
             ResultSet resultSet = statement.executeQuery(SELECT_AUTHORS)) {

            List<Author> authors = new ArrayList<>();
            while (resultSet.next()) {

                Author author = new Author();
                author.setId(resultSet.getInt(1));
                author.setName(resultSet.getString(2));

                authors.add(author);
            }

            return authors;

        } catch (SQLException e) {
            System.out.println("Couldn't execute queryAllArtists()...");
            System.out.println(e.getMessage());
            return null;
        }
    }

    public List<Author> queryAuthorsByName(String nameIdentifier) {
        try {
            queryAuthorsByNamePreparedStatement = conn.prepareStatement(SELECT_AUTHORS_BY_NAME);
            queryAuthorsByNamePreparedStatement.setString(1, "%" + nameIdentifier + "%");
            ResultSet resultSet = queryAuthorsByNamePreparedStatement.executeQuery();

            List<Author> authors = new ArrayList<>();
            while (resultSet.next()) {

                Author author = new Author();
                author.setId(resultSet.getInt(1));
                author.setName(resultSet.getString(2));

                authors.add(author);
            }

            return authors;

        } catch (SQLException e) {
            System.out.println("Couldn't execute queryAuthorsByName(String nameIdentifier)...");
            System.out.println(e.getMessage());
            return null;
        }
    }

    public int countAllAuthors() {
        try (Statement statement = conn.createStatement();
             ResultSet resultSet = statement.executeQuery(COUNT_AUTHORS)) {

            if (resultSet.next()) {
                return resultSet.getInt(1);
            } else {
                throw new SQLException();
            }
        } catch (SQLException e) {
            System.out.println("Couldn't execute countAllAuthors()...");
            System.out.println(e.getMessage());
            return -1;
        }
    }

    public List<Book> queryBooksByTitle(String nameIdentifier) {
        try {
            queryBooksByTitlePreparedStatement = conn.prepareStatement(SELECT_BOOKS_BY_TITLE);
            queryBooksByTitlePreparedStatement.setString(1, "%" + nameIdentifier + "%");
            ResultSet resultSet = queryBooksByTitlePreparedStatement.executeQuery();

            List<Book> books = new ArrayList<>();
            while (resultSet.next()) {

                Book book = new Book();
                book.setId(resultSet.getInt(1));
                book.setAuthor_id(resultSet.getInt(2));
                book.setTitle(resultSet.getString(3));
                book.setPublish_date(resultSet.getDate(4));
                book.setPrice(resultSet.getFloat(5));

                books.add(book);
            }

            return books;

        } catch (SQLException e) {
            System.out.println("Couldn't execute queryBooksByName(String nameIdentifier)...");
            System.out.println(e.getMessage());
            return null;
        }
    }

    public List<Book> filterBooksByPrice(int price, boolean lower) {
        try {
            if (lower) {
                filterBooksByPrice = conn.prepareStatement(SELECT_BOOKS_BY_PRICE_LOWER_THAN);
            } else {
                filterBooksByPrice = conn.prepareStatement(SELECT_BOOKS_BY_PRICE_HIGHER_THAN);
            }

            filterBooksByPrice.setInt(1, price);
            ResultSet resultSet = filterBooksByPrice.executeQuery();

            List<Book> books = new ArrayList<>();
            while (resultSet.next()) {

                Book book = new Book();
                book.setId(resultSet.getInt(1));
                book.setAuthor_id(resultSet.getInt(2));
                book.setTitle(resultSet.getString(3));
                book.setPublish_date(resultSet.getDate(4));
                book.setPrice(resultSet.getFloat(5));

                books.add(book);
            }

            return books;

        } catch (SQLException e) {
            System.out.println("Couldn't execute queryBooksByPrice(int price, boolean lower)...");
            System.out.println(e.getMessage());
            return null;
        }
    }

    public List<Book> orderBooksByPrice(boolean asc) {
        try {
            if (asc) {
                orderBooksByPrice = conn.prepareStatement(SELECT_BOOKS_ORDER_BY_PRICE_LOW_TO_HIGH);
            } else {
                orderBooksByPrice = conn.prepareStatement(SELECT_BOOKS_ORDER_BY_PRICE_HIGH_TO_LOW);
            }
            ResultSet resultSet = orderBooksByPrice.executeQuery();

            List<Book> books = new ArrayList<>();
            while (resultSet.next()) {

                Book book = new Book();
                book.setId(resultSet.getInt(1));
                book.setAuthor_id(resultSet.getInt(2));
                book.setTitle(resultSet.getString(3));
                book.setPublish_date(resultSet.getDate(4));
                book.setPrice(resultSet.getFloat(5));

                books.add(book);
            }

            return books;
        } catch (SQLException e) {
            System.out.println("Couldn't execute orderBooksByPrice(boolean asc)...");
            System.out.println(e.getMessage());
            return null;
        }
    }

    private int insertAuthor(String name) throws SQLException { //this method will ONLY THROW the SQLException,
        //  rather than handling it , because we will catch and handle it in the insertBook method ! ( because we want to make sure IN THAT method
        //  that all the previous actions were done successfully )

        queryAuthors = conn.prepareStatement(QUERY_AUTHORS);
        queryAuthors.setString(1, name); //this query returns the artist with the "name" name (if found)
        ResultSet results = queryAuthors.executeQuery();

        if (results.next()) {
            return results.getInt(1); // this in case we found the author in the DB and we no longer need
            // to insert him/her , and we just return the id where he/she is located
        } else {
            //Insert the artist (if not previously found)
            insertIntoAuthors = conn.prepareStatement(INSERT_AUTHOR, Statement.RETURN_GENERATED_KEYS);
            insertIntoAuthors.setString(1, name);

            int affectedRows = insertIntoAuthors.executeUpdate();
            if (affectedRows != 1) {
                throw new SQLException("Couldn't insert author...");
            }
            ResultSet generatedKeys = insertIntoAuthors.getGeneratedKeys();
            if (generatedKeys.next()) {
                return generatedKeys.getInt(1);
            } else {
                throw new SQLException("Couldn't get id for author...");
            }
        }
    }

    public void insertBook(String author, String title, Date publish_date, float price) {

        try {
            conn.setAutoCommit(false); //to begin a transaction (auto-commit is set to false so that the db can rollback
            // any changes in case something goes wrong and the transaction cannot be done FULLY SUCCESSFUL)

            queryBooks = conn.prepareStatement(QUERY_BOOKS);
            queryBooks.setString(1, title);
            ResultSet resultSet = queryBooks.executeQuery();

            if (!resultSet.next()) {  // if the book was NOT ALREADY in the DB
                int authorId = insertAuthor(author);

                insertIntoBooks = conn.prepareStatement(INSERT_BOOK);
                insertIntoBooks.setInt(1, authorId);
                insertIntoBooks.setString(2, title);
                insertIntoBooks.setDate(3, publish_date);
                insertIntoBooks.setFloat(4, price);


                int affectedRows = insertIntoBooks.executeUpdate();  //this line executes the ACTUAL INSERT of the song and returns
                //  information about its effect on the DB (usually the
                //  "affectedRows" should be 1 --> only one row of the table should be affected if we add a song)
                if (affectedRows == 1) {
                    conn.commit(); //this finishes the transaction and makes the previous changes PERMANENT to the DB
                } else {
                    throw new SQLException("Book insert failed...");
                }
            } else {
                System.out.println("\"" + title + "\" already registered...");
            }

        } catch (Exception e) {
            System.out.println("Insert book exception : " + e.getMessage());
            try {
                System.out.println("Performing rollback!");
                conn.rollback();  // this performs a "ROLLBACK" on the previous changes , so they will not be saved to
                //  the DB (this is in case something went wrong , so we  want the changes to be done
                //  ONLY if everything was successful , OR NOT AT ALL
            } catch (SQLException e2) {
                System.out.println("Oh boy........ " + e.getMessage()); // this would is very unlikely to happen and it would be BAD
            }
        } finally {
            try {
                System.out.println("Resetting default commit behavior ");
                conn.setAutoCommit(true);  // finishing the transaction "STATE" (the auto-commit is eventually set to AUTO again
                //  so all the changes will be automatically saved to the DB
            } catch (SQLException e3) {
                System.out.println("Couldn't reset auto-commit :" + e3.getMessage()); // thi is BAD
            }
        }
    }

    public void deleteBook(String title) {
        try {
            deleteFromBooks = conn.prepareStatement(DELETE_BOOK);
            deleteFromBooks.setString(1, title);

            int affectedRows = deleteFromBooks.executeUpdate();
            if (affectedRows < 1) {
                throw new SQLException();
            }
        } catch (SQLException e) {
            System.out.println("Couldn't execute deleteBook(String title)...");
            System.out.println(e.getMessage());
        }
    }
}
