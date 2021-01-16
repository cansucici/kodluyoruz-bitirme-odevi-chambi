package org.kodluyoruz.group1.library.dao;

import org.kodluyoruz.group1.library.model.entities.Books;
import org.springframework.data.repository.query.Param;

import java.util.Collection;


public interface BookRepository {

    Books create(Books books);

    Books update(Books books);

    void delete(Long id);

    Collection<Books> list();

    Collection<Books> findBooksByKeyword(@Param("keyword") String keyword);

    Collection<Books> getOrderedBooks();

}
