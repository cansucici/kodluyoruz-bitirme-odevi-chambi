package org.kodluyoruz.group1.library.converter;

import org.kodluyoruz.group1.library.dto.AuthorDTO;
import org.kodluyoruz.group1.library.model.entities.Author;
import org.springframework.stereotype.Service;

@Service
public class AuthorConverter implements IAuthorConverter {

    @Override
    public Author convertToAuthor(AuthorDTO authorDTO) {

        Author author = new Author();
        author.setId(authorDTO.getId());
        author.setNameSurname(authorDTO.getNameSurname());
        author.setAbout(authorDTO.getAbout());
        author.setUpdateDate(authorDTO.getUpdateDate());
        author.setDeleted(authorDTO.isDeleted());
        author.setCreateDate(authorDTO.getCreateDate());
        author.setBooks(authorDTO.getBooks());
        return author;
    }

    @Override
    public AuthorDTO convertToAuthorDto(Author author) {

        AuthorDTO authorDTO = new AuthorDTO();
        authorDTO.setId(author.getId());
        authorDTO.setNameSurname(author.getNameSurname());
        authorDTO.setAbout(author.getAbout());
        authorDTO.setUpdateDate(author.getUpdateDate());
        authorDTO.setDeleted(author.isDeleted());
        authorDTO.setCreateDate(author.getCreateDate());
        authorDTO.setBooks(author.getBooks());
        return authorDTO;
    }
}
