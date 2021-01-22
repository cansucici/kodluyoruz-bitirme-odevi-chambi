package org.kodluyoruz.group1.library.service;

import org.kodluyoruz.group1.library.dto.AuthorDTO;
import org.kodluyoruz.group1.library.model.entities.Author;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public interface AuthorService {

    Author saveAuthor(AuthorDTO dto);

    Collection<Author> getAllActive();

<<<<<<< HEAD
    Author findByNameSurname(String nameSurname);
=======
    Collection<Author> findByNameSurname(String name,String surname); //can have same namesurname
>>>>>>> 5e511ea (author's changed)

    void deleteById(Long id);

    Author updateAuthor(AuthorDTO dto);

}
