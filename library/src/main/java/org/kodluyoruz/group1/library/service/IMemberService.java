package org.kodluyoruz.group1.library.service;

import org.kodluyoruz.group1.library.dto.MemberDTO;
import org.kodluyoruz.group1.library.model.entities.Member;

import java.util.List;

public interface IMemberService {

    List<Member> getAll();

    Member create(MemberDTO memberDTO) ;

    Member updatePassword(Long id, MemberDTO memberDTO);

    Member update(Long id, MemberDTO memberDTO) throws Exception;

    Member getById(Long id) throws Exception;

    Member delete(Long id) throws Exception;

    Member updateMemberStatus(Long id, MemberDTO memberDTO) throws Exception;

    Member takeBook(Long bookId) throws Exception;

    Member findByUserName(String userName);
}
