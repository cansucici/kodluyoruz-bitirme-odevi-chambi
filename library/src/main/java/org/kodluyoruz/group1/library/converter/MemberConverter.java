package org.kodluyoruz.group1.library.converter;

import org.kodluyoruz.group1.library.dto.MemberDTO;
import org.kodluyoruz.group1.library.model.entities.Member;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class MemberConverter implements IBaseConverter<Member, MemberDTO> {

    private final ModelMapper modelMapper;

    @Override
    public MemberDTO convertToDto(Member entity) {
        return modelMapper.map(entity, MemberDTO.class);
    }

    @Override
    public Member convertToEntity(MemberDTO dto) {
        return modelMapper.map(dto, Member.class);
    }
}
