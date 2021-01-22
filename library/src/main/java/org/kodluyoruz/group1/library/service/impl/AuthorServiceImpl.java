package org.kodluyoruz.group1.library.service.impl;

import lombok.RequiredArgsConstructor;
import org.kodluyoruz.group1.library.dao.AuthorRepository;
import org.kodluyoruz.group1.library.dto.AuthorDTO;
import org.kodluyoruz.group1.library.exceptions.AuthorNotFoundException;
import org.kodluyoruz.group1.library.model.entities.Author;
import org.kodluyoruz.group1.library.service.AuthorConverterService;
import org.kodluyoruz.group1.library.service.AuthorService;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Date;

@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;
    private final AuthorConverterService converterService;

    @Override

    public Author save(AuthorDTO dto) {
        Author author = converterService.convertToAuthor(dto);
        return authorRepository.save(author);
    }

    @Override
    public Collection<Author> getAllActive() {
        return authorRepository.findAllByDeletedIsFalse();

    }

    @Override
    public void deleteById(Long id) {
        authorRepository.deleteAuthor(id);
    }

    @Override
    public Author update(AuthorDTO dto) {
        Author author = authorRepository.findById(dto.getId())
                .orElseThrow(() -> new AuthorNotFoundException("Böyle bir yazar bilgisi mevcut değildir."));
        author.setUpdateDate(new Date());
        author.setDeleted(dto.isDeleted());
        author.setAbout(dto.getAbout());
        author.setNameSurname(dto.getNameSurname());
        authorRepo
        return author;
     
    }
    @Override

    public Author findByNameSurname(String nameSurname) {

        return authorRepository.findAuthorByNameSurnameLikeAndDeletedIsFalse(nameSurname);

    }
}