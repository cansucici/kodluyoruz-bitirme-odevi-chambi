package org.kodluyoruz.group1.library.service;


import org.kodluyoruz.group1.library.dto.BookDTO;
import org.kodluyoruz.group1.library.model.entities.Book;

import java.util.Collection;
import java.util.List;

public interface IBookService {

    Collection<Book> getAllBooks();

    Book save(BookDTO dto);

    Book update(Long id, BookDTO dto);

    BookDTO getBookById(Long id);

    void deleteBook(Long id); //deleted

    List<Book> getBooksByBookName(String bookName);
}
