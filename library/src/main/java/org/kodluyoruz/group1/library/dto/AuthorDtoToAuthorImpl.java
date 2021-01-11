package org.kodluyoruz.group1.library.dto;

import org.kodluyoruz.group1.library.dto.interfaces.Converter;
import org.kodluyoruz.group1.library.model.entities.Authors;
import org.springframework.stereotype.Component;

@Component
public class AuthorDtoToAuthorImpl implements Converter<AuthorDTO, Authors> {

    @Override
    public Authors convert(AuthorDTO input) {
       Authors  authors=new Authors();
       authors.setId(input.getId());
       authors.setNameSurname(input.getNameSurname());
       authors.setAbout(input.getAbout());
       authors.setUpdateDate(input.getUpdateDate());
       authors.setDeleted(input.isDeleted());
       authors.setCreateDate(input.getCreateDate());

       return authors;
    }
}
