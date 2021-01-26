package org.kodluyoruz.group1.library.converter;

import org.kodluyoruz.group1.library.dto.MemberDTO;
import org.kodluyoruz.group1.library.model.entities.Member;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberConverter implements IBaseConverter<Member, MemberDTO> {

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public MemberDTO convertToDto(Member entity) {
        return modelMapper.map(entity, MemberDTO.class);
    }

    @Override
    public Member convertToEntity(MemberDTO dto) {
        return modelMapper.map(dto, Member.class);
    }
}
