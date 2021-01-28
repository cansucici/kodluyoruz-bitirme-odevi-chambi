package org.kodluyoruz.group1.library.converter;

import lombok.RequiredArgsConstructor;
import org.kodluyoruz.group1.library.dto.BookDTO;
import org.kodluyoruz.group1.library.model.entities.Book;
import org.kodluyoruz.group1.library.service.IAuthorService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BookConverter implements IBaseConverter<Book, BookDTO> {

    private final ModelMapper modelMapper;
    private final IAuthorService authorService;

    @Override
    public BookDTO convertToDto(Book entity) {
        return modelMapper.map(entity, BookDTO.class);
    }

    @Override
    public Book convertToEntity(BookDTO dto) {
        Book book = modelMapper.map(dto, Book.class);
        book.setAuthors(authorService.getAllByNameSurname(dto.getAuthors()));
        return book;
    }

//    public Book convert(BookDTO bookDTO, List<Author> authors) {
//        Book book = new Book();
//
//        book.setDeleted(bookDTO.isDeleted());
//        book.setPublisherName(bookDTO.getPublisherName());
//        book.setCategory(bookDTO.getCategory());
//        book.setLanguagesEnum(bookDTO.getLanguagesEnum());
//        book.setEditionNumber(bookDTO.getEditionNumber());
//        book.setPageNumber(bookDTO.getPageNumber());
//        book.setIsbn(bookDTO.getIsbn());
//        book.setBookName(bookDTO.getBookName());
//        book.setStatus(bookDTO.getStatus());
//        book.setAuthors(authors);
//
//        return book;
//    }
}
