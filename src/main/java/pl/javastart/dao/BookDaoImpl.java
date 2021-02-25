package pl.javastart.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import pl.javastart.model.Book;

@Repository
public class BookDaoImpl implements BookDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public void save(Book book) {
        entityManager.persist(book);
    }

    @Override
    public Book get(Long id) {
        Book book = entityManager.find(Book.class, id);
        return book;
    }
}