package org.kodluyoruz.group1.library.service.impl;

import org.kodluyoruz.group1.library.dto.AuthorDTO;
import org.kodluyoruz.group1.library.model.entities.Authors;
import org.kodluyoruz.group1.library.service.AuthorConverterService;
import org.springframework.stereotype.Service;

@Service
public class AuthorConverterServiceImpl implements AuthorConverterService {


    @Override
    public Authors convertToAuthor(AuthorDTO authorDTO) {
        Authors  authors=new Authors();
        authors.setId(authorDTO.getId());
        authors.setNameSurname(authorDTO.getNameSurname());
        authors.setAbout(authorDTO.getAbout());
        authors.setUpdateDate(authorDTO.getUpdateDate());
        authors.setDeleted(authorDTO.isDeleted());
        authors.setCreateDate(authorDTO.getCreateDate());

        return authors;

    }

    @Override
    public AuthorDTO convertToAuthorDto(Authors author) {
        AuthorDTO  authorDTO=new AuthorDTO();
        authorDTO.setId(author.getId());
        authorDTO.setNameSurname(author.getNameSurname());
        authorDTO.setAbout(author.getAbout());
        authorDTO.setUpdateDate(author.getUpdateDate());
        authorDTO.setDeleted(author.isDeleted());
        authorDTO.setCreateDate(author.getCreateDate());

        return authorDTO;
    }
}
