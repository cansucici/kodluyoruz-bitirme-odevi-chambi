package org.kodluyoruz.group1.library.service;

import org.kodluyoruz.group1.library.dto.AuthorDTO;
import org.kodluyoruz.group1.library.model.entities.Authors;
import org.springframework.stereotype.Service;

import java.util.Collection;


public interface AuthorService {

    Authors save(AuthorDTO authorDTO);
    Collection<Authors> getAllAuthors();
    Authors getByNameSurname(String nameSurname);
    void deleteByNameSurname(String name);

}