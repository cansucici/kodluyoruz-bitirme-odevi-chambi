package org.kodluyoruz.group1.library.service;

import org.kodluyoruz.group1.library.dto.AuthorDTO;
import org.kodluyoruz.group1.library.model.entities.Authors;

public interface AuthorConverterService {

    Authors convertToAuthor(AuthorDTO authorDTO);
    AuthorDTO convertToAuthorDto(Authors author);
}
