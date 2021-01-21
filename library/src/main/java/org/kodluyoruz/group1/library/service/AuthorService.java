package org.kodluyoruz.group1.library.service;

import org.kodluyoruz.group1.library.dto.AuthorDTO;
import org.kodluyoruz.group1.library.model.entities.Author;

import java.util.Collection;

public interface AuthorService {

    Author saveAuthor(AuthorDTO dto);

    Collection<Author> getAllActive();

    Collection<Author> findByNameSurname(String nameSurname); //can have same namesurname

    void deleteById(Long id);

    Author updateAuthor(AuthorDTO dto);

}
