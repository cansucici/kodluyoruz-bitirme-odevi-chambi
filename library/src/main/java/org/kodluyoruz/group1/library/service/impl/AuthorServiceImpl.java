package org.kodluyoruz.group1.library.service.impl;

import lombok.RequiredArgsConstructor;
import org.kodluyoruz.group1.library.dao.AuthorRepository;
import org.kodluyoruz.group1.library.dto.AuthorDTO;
import org.kodluyoruz.group1.library.model.entities.Authors;
import org.kodluyoruz.group1.library.service.AuthorConverterService;
import org.kodluyoruz.group1.library.service.AuthorService;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@RequiredArgsConstructor
@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository repository;
    private final AuthorConverterService service;

    @Override
    public Authors save(AuthorDTO authorDTO) {

        Authors author=service.convertToAuthor(authorDTO);

        return repository.save(author);
    }

    @Override
    public Collection<Authors> getAllAuthors() {
        List<Authors> allAuthors= repository.findAll();
        return allAuthors;
    }

    @Override
    public Authors getByNameSurname(String nameSurname) {
        return null;
    }


    @Override
    public void deleteByNameSurname(String name) {

    }


}
