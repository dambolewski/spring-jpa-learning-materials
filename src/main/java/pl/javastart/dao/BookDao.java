package pl.javastart.dao;

import pl.javastart.model.Book;

public interface BookDao {
    void save(Book book);
    Book get(Long id);
    public void update(Book book);
    public void remove(Long bookId);
}