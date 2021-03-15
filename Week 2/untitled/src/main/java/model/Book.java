package model;

import java.util.Date;

public class Book {
    private int id;
    private int author_id;
    private String title;
    private Date publish_date;
    private float price;

    public Book() {
    }

    public Book(int id, int author_id, String title, Date publish_date, float price) {
        this.id = id;
        this.author_id = author_id;
        this.title = title;
        this.publish_date = publish_date;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public int getAuthor_id() {
        return author_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getPublish_date() {
        return publish_date;
    }

    public void setPublish_date(Date publish_date) {
        this.publish_date = publish_date;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAuthor_id(int author_id) {
        this.author_id = author_id;
    }
}