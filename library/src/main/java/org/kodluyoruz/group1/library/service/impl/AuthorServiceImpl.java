package org.kodluyoruz.group1.library.service.impl;

import lombok.RequiredArgsConstructor;
import org.kodluyoruz.group1.library.dao.AuthorRepository;
import org.kodluyoruz.group1.library.dto.AuthorDTO;
import org.kodluyoruz.group1.library.model.entities.Author;
import org.kodluyoruz.group1.library.service.AuthorConverterService;
import org.kodluyoruz.group1.library.service.AuthorService;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;
    private final AuthorConverterService converterService;

    @Override
    public Author saveAuthor(AuthorDTO dto) {
        Author author = converterService.convertToAuthor(dto);
        return authorRepository.save(author);
    }

    @Override
    public Collection<Author> getAllActive() {
        List<Author> authors = authorRepository.findAllByDeletedIsFalse();
        return authors;
    }

    @Override
    public void deleteById(Long id) {
        authorRepository.updateAuthorStatus(id);
    }

    @Override
    public Author updateAuthor(AuthorDTO dto) {
      Author author=authorRepository.findById(dto.getId()).orElse(null);
        author.setUpdateDate(new Date());
        author.setDeleted(dto.isDeleted());
        author.setAbout(dto.getAbout());
      author.setNameSurname(dto.getNameSurname());
      return authorRepository.save(author);
    }

    @Override
    public Author findByNameSurname(String nameSurname) {

        return authorRepository.findAuthorByNameSurnameAndDeletedIsFalse(nameSurname);
    }
}
