package org.kodluyoruz.group1.library.service;

import org.kodluyoruz.group1.library.dto.AuthorDTO;
import org.kodluyoruz.group1.library.model.entities.Author;

public interface AuthorConverterService {

    Author convertToAuthor(AuthorDTO authorDTO);
    AuthorDTO convertToAuthorDto(Author author);
}
