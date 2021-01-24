package org.kodluyoruz.group1.library.service;


import org.kodluyoruz.group1.library.dto.BookDTO;
import org.kodluyoruz.group1.library.model.entities.Book;
import org.springframework.expression.spel.support.ReflectivePropertyAccessor;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface BookService {

        Collection<Book> getAllBooks();

        Book save (BookDTO dto);

        Book update (Long id,BookDTO dto);

        BookDTO getBookById(Long id);

    void deleteBook(Long id); //deleted

    List<Book> getBooksByBookName (String bookName);






    /*public void delete(BaseDTO id) {
         bookRepository.delete(id.getId());
    }*/




    //Collection<BookDTO> getOrderedBooks();

}
