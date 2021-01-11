package org.kodluyoruz.group1.library.dto;

import org.kodluyoruz.group1.library.dto.interfaces.Converter;
import org.kodluyoruz.group1.library.model.entities.Authors;
import org.springframework.stereotype.Component;

@Component
public class AuthorToAuthorDto implements Converter<Authors,AuthorDTO> {
    @Override
    public AuthorDTO convert(Authors input) {
        AuthorDTO  authorDTO=new AuthorDTO();
        authorDTO.setId(input.getId());
        authorDTO.setNameSurname(input.getNameSurname());
        authorDTO.setAbout(input.getAbout());
        authorDTO.setUpdateDate(input.getUpdateDate());
        authorDTO.setDeleted(input.isDeleted());
        authorDTO.setCreateDate(input.getCreateDate());

        return authorDTO;
    }
}
