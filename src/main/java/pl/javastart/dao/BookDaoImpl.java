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
        return entityManager.find(Book.class, id);
    }

    @Override
    @Transactional
    public void update(Book book){
        Book find = entityManager.find(Book.class, book.getId());
        if(find!=null){
            find.setTitle(book.getTitle());
            find.setIsbn(book.getIsbn());
            find.setAuthor(book.getAuthor());
        }
    }

    @Override
    @Transactional
    public void remove(Long bookId){
        Book objToRemove = entityManager.find(Book.class,bookId);
        entityManager.remove(objToRemove);
    }

}