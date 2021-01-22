package org.kodluyoruz.group1.library.service;

import org.kodluyoruz.group1.library.dto.AuthorDTO;
import org.kodluyoruz.group1.library.model.entities.Author;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public interface AuthorService {

    Author saveAuthor(AuthorDTO dto);

    Collection<Author> getAllActive();

    Author findByNameSurname(String nameSurname);

    void deleteById(Long id);

    Author updateAuthor(AuthorDTO dto);

}
