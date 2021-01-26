package org.kodluyoruz.group1.library.service;

import org.kodluyoruz.group1.library.dto.MemberDTO;
import org.kodluyoruz.group1.library.model.entities.Member;

import java.util.List;

public interface IMemberService {

    List<Member> getAll();

    Member create(MemberDTO memberDTO) throws Exception;

    Member updatePassword(Long id, Member member);

    Member update(Long id, Member member) throws Exception;

    Member getById(Long id) throws Exception;

    Member delete(Long id) throws Exception;

    Member updateMemberStatus(Long id, Member member) throws Exception;

    Member takeBook(Long bookId) throws Exception;

    Member findByUserName(String userName);
}
