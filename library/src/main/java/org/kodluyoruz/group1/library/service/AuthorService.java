package org.kodluyoruz.group1.library.service;

import org.kodluyoruz.group1.library.dto.AuthorDTO;
import org.kodluyoruz.group1.library.model.entities.Authors;

import java.util.Collection;


public interface AuthorService{

    Authors saveAuthor(AuthorDTO dto);
    Collection<Authors> getAllActive();
  Collection<Authors> findByNameSurname(String name); //can have same namesurname
    void deleteById(Long id);
Authors updateAuthor(AuthorDTO dto);

}
