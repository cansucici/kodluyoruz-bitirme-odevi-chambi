package org.kodluyoruz.group1.library.converter;

import org.kodluyoruz.group1.library.dto.BaseDTO;
import org.kodluyoruz.group1.library.dto.BookDTO;
import org.kodluyoruz.group1.library.model.entities.Book;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class BookConverter {

    @Autowired
    private ModelMapper modelMapper;

    public BookDTO convertToDto(Book book) {

        return modelMapper.map(book, BookDTO.class);
    }

    public Book convertToEntity(BaseDTO dto) {
        return null;
    }
}
