package org.kodluyoruz.group1.library.converter;

import org.kodluyoruz.group1.library.dto.BookDTO;
import org.kodluyoruz.group1.library.model.entities.Book;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BookConverter implements IBaseConverter<Book, BookDTO> {

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public BookDTO convertToDto(Book entity) {
        return modelMapper.map(entity, BookDTO.class);
    }

    @Override
    public Book convertToEntity(BookDTO dto) {
        return modelMapper.map(dto, Book.class);
    }
}
