package com.arobs.library.repository;

import com.arobs.library.model.Book;
import com.arobs.library.repository.hibernate.HibernateUtil;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.Calendar;

@Repository
public class BookRepositoryHibernate {

    private static Date currentDate = new Date(Calendar.getInstance().getTime().getTime());

    public Book getBookById(int id){

        Session session  = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Book book = session.load(Book.class, id);
        session.getTransaction().commit();
        return book;
    }


}
