//package com.arobs.library.repository.hibernate;
//
//import com.arobs.library.model.Book;
//import org.hibernate.Session;
//
//import java.sql.Date;
//import java.util.Calendar;
//
//public class MainApp {
//    private static Date currentDate;
//
//    public static void main(String[] args) {
//        currentDate = new Date(Calendar.getInstance().getTime().getTime());
//
//        Session session1 = HibernateUtil.getSessionFactory().openSession();
//        session1.beginTransaction();
//
////        Book b1 = new Book("First Book","This is the very first saved book",currentDate);
//
//        session1.save(b1);
//
//        Integer b1Id = b1.getId();
//        session1.getTransaction().commit();
//
//        /////////////////////////////////////////////////////////////////////////////
//
//        Session session2 = HibernateUtil.getSessionFactory().openSession();
//        session2.beginTransaction();
//
//        Book loadedB1 = (Book) session2.load(Book.class, b1Id);
////        System.out.println("Book 1 : title = " + loadedB1.getTitle() + ", description = " + loadedB1.getDescription() + ", addedDate = " + loadedB1.getAddedDate());
//
//        System.out.println(session2.getEntityName(loadedB1));
//
//        session2.getTransaction().commit();
//
//        HibernateUtil.shutdown();
//    }
//}