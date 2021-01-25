package org.kodluyoruz.group1.library.converter;

import org.kodluyoruz.group1.library.dto.AuthorDTO;
import org.kodluyoruz.group1.library.model.entities.Author;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AuthorConverter implements IBaseConverter<Author, AuthorDTO> {

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public AuthorDTO convertToDto(Author entity) {
        return modelMapper.map(entity, AuthorDTO.class);
    }

    @Override
    public Author convertToEntity(AuthorDTO dto) {
        return modelMapper.map(dto, Author.class);
    }
}
