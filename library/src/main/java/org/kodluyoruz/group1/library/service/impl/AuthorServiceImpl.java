package org.kodluyoruz.group1.library.service.impl;

import lombok.RequiredArgsConstructor;
import org.kodluyoruz.group1.library.dao.AuthorRepository;
import org.kodluyoruz.group1.library.dto.AuthorDTO;
import org.kodluyoruz.group1.library.model.entities.Authors;
import org.kodluyoruz.group1.library.service.AuthorService;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository repository;
    private final AuthorConverterServiceImpl converterService;

    @Override
    public Authors saveAuthor(AuthorDTO dto) {

        Authors author = converterService.convertToAuthor(dto);
        return repository.save(author);
    }

    @Override
    public Collection<Authors> getAllActive() {
        List<Authors> authors = repository.findAll();
        return authors;

    }

    @Override
    public void deleteById(Long id) {
        repository.updateAuthorStatus(id);
    }

    @Override
    public Authors updateAuthor(AuthorDTO dto) {
      Authors author=repository.findById(dto.getId()).orElse(null);
        author.setUpdateDate(new Date());
        author.setDeleted(dto.isDeleted());
        author.setAbout(dto.getAbout());
        author.setNameSurname(dto.getNameSurname());
      return repository.save(author);
    }

    @Override
    public Collection<Authors> findByNameSurname(String name) {

        return repository.findAllByNameSurname(name);
    }
}
