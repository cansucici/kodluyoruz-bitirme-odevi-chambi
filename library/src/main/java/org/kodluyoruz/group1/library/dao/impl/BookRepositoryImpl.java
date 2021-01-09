package org.kodluyoruz.group1.library.dao.impl;

import org.kodluyoruz.group1.library.base.LibraryAPIRepositoryImpl;
import org.kodluyoruz.group1.library.dao.BookRepository;
import org.kodluyoruz.group1.library.model.entities.Books;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public class BookRepositoryImpl extends LibraryAPIRepositoryImpl<Books, Long> implements BookRepository {

    @Override
    public Collection<Books> findBooksByKeyword(String keyword) {
        return getSession()
                .createQuery("SELECT b FROM Books b WHERE b.bookName LIKE %:keyword%")
                .getResultList();
    }

    @Override
    public Collection<Books> getOrderedBooks() {
        return getSession()
                .createQuery("SELECT b FROM Books b ORDER BY b.id DESC ")
                .getResultList();
    }
}

