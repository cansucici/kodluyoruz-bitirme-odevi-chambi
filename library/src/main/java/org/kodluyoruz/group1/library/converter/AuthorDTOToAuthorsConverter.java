package org.kodluyoruz.group1.library.converter;


import org.kodluyoruz.group1.library.convert.LibraryAPIConverter;
import org.kodluyoruz.group1.library.dto.AuthorDTO;
import org.kodluyoruz.group1.library.model.entities.Author;
import org.springframework.stereotype.Component;

@Component
public class AuthorDTOToAuthorsConverter implements LibraryAPIConverter<AuthorDTO, Author> {
    @Override
    public Author convert(AuthorDTO input) {

        Author author = new Author();
        author.setId(input.getId());
        author.setNameSurname(input.getNameSurname());
        author.setAbout(input.getAbout());
        author.setCreateDate(input.getCreateDate());
        author.setUpdateDate(input.getUpdateDate());
        author.setDeleted(input.isDeleted());

        //authors.setBooks(input.getBooks());
        return author;
    }
}
