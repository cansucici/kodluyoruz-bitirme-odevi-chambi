package org.kodluyoruz.group1.library.service;

import org.kodluyoruz.group1.library.dto.MemberDTO;
import org.kodluyoruz.group1.library.model.entities.Member;
import java.util.List;

public interface IMemberService {

    List<Member> getAll();

    Member create(MemberDTO memberDTO) ;

    Member updatePassword(MemberDTO memberDTO);

    Member update(String userName, MemberDTO memberDTO);

    Member getById(Long id);

    Member delete(Long id);

    Member updateMemberStatus(Long id);

    Member takeBook(Long bookId);

    Member giveBook(Long bookId);

    Member findByUserName(String userName);
}
