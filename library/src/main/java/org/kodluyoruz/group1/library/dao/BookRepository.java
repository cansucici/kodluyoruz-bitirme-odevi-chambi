package org.kodluyoruz.group1.library.dao;

import io.lettuce.core.dynamic.annotation.Param;
import org.kodluyoruz.group1.library.model.entities.Books;

import java.awt.print.Book;
import java.util.Collection;
import java.util.List;


public interface BookRepository {

    Books create(Books books);

    Books update(Books books);

    void delete(Long id);

    Collection<Books> list();

    Collection<Books> findBooksByKeyword(@Param("keyword") String keyword);

    Collection<Books> getOrderedBooks();

}
