package org.kodluyoruz.group1.library.converter;


import org.kodluyoruz.group1.library.dto.BookDTO;
import org.kodluyoruz.group1.library.model.entities.Book;
import org.springframework.stereotype.Component;

@Component
public class BookDTOToBooksConverter implements BaseConverter<BookDTO, Book> {

    @Override
    public Book convert(BookDTO input) {

        Book book = new Book();

        book.setId(input.getId());
        book.setBookName(input.getBookName());
        book.setPageNumber(input.getPageNumber());
        book.setPublisherName(input.getPublisherName());
        book.setEditionNumber(input.getEditionNumber());
        book.setIsbn(input.getIsbn());
        book.setLanguagesEnum(input.getLanguagesEnum());
        book.setCategory(input.getCategory());
        book.setStatus(input.getStatus());
        book.setCreateDate(input.getCreateDate());
        book.setUpdateDate(input.getUpdateDate());
        book.setDeleted(input.isDeleted());

        book.setAuthors(input.getAuthors());
        book.setMember(input.getMember());



        return book;
    }
}
