package org.kodluyoruz.group1.library.converter;

import org.kodluyoruz.group1.library.dto.AuthorDTO;
import org.kodluyoruz.group1.library.model.entities.Author;

public interface IAuthorConverter {

    Author convertToAuthor(AuthorDTO authorDTO);
    AuthorDTO convertToAuthorDto(Author author);
}
