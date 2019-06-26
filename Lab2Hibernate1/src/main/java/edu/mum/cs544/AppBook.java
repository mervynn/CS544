package edu.mum.cs544;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

public class AppBook {
    private static EntityManagerFactory emf;

    public static void main(String args[]) throws ParseException {
        emf = Persistence.createEntityManagerFactory("cs544");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Book[] books = new Book[3];
        books[0] = new Book(null, "A Tale of Two Cities", "978-1503219700",
                "Charles Dickens", 9.99D, sdf.parse("18590701"));
        books[1] = new Book(null, "The Lord of the Rings", "978-0395489321",
                "J. R. R. Tolkien", 37.50, sdf.parse("19540729"));
        books[2] = new Book(null, "The Little Prince", "978-0156012195",
                "Antoine de Saint-Exupéry", 10.24, sdf.parse("20000515"));
        for (Book book : books) em.persist(book);
        em.getTransaction().commit();
        em.close();

        em = emf.createEntityManager();
        em.getTransaction().begin();
        TypedQuery<Book> query = em.createQuery("from Book", Book.class);
        List<Book> bookList = query.getResultList();
        for (Book book : bookList) System.out.println(book);
        em.getTransaction().commit();
        em.close();

        em = emf.createEntityManager();
        em.getTransaction().begin();
        query = em.createQuery("from Book", Book.class);
        bookList = query.getResultList();
        Book book2Change = bookList.get(0);
        book2Change.setTitle("Black Whole");
        book2Change.setPrice(9999.99);
        em.persist(book2Change);
        Book book2Remove = bookList.get(1);
        em.remove(book2Remove);
        em.getTransaction().commit();
        em.close();

        em = emf.createEntityManager();
        em.getTransaction().begin();
        query = em.createQuery("from Book", Book.class);
        bookList = query.getResultList();
        for (Book book : bookList) System.out.println(book);
        em.getTransaction().commit();
        em.close();

    }
}
