package org.kodluyoruz.group1.library.service.impl;

import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.kodluyoruz.group1.library.converter.BookConverter;
import org.kodluyoruz.group1.library.converter.MemberConverter;
import org.kodluyoruz.group1.library.dao.MemberRepository;
import org.kodluyoruz.group1.library.dto.MemberDTO;
import org.kodluyoruz.group1.library.model.entities.Book;
import org.kodluyoruz.group1.library.model.entities.Member;
import org.kodluyoruz.group1.library.model.enums.StatusEnum;
import org.kodluyoruz.group1.library.service.IMemberService;
import org.kodluyoruz.group1.library.utils.SecurityUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService implements IMemberService {

    private final MemberRepository memberRepository;
    private final MemberConverter memberConverter;
    private final BookService bookService;
    private final BookConverter bookConverter;
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    public List<Member> getAll() {
        return memberRepository.findAll();
    }

    @Override
    public Member create(MemberDTO memberDTO) throws Exception {

        String encodedPassword = bCryptPasswordEncoder.encode(memberDTO.getPassword());
        memberDTO.setPassword(encodedPassword);
        if (memberRepository.existsByUserNameAndDeleted(memberDTO.getUserName(), false)) {
            throw new RuntimeException("Bu username kullanılmakta!");
        }
        if (memberRepository.existsByEmail(memberDTO.getEmail())) {
            throw new Exception("Bu email kullanılmakta, Lütfen başka bir email ile kayıt olunuz!!");
        }

        Member member = memberConverter.convertToEntity(memberDTO);
        return memberRepository.save(member);
    }

    @Override
    public Member updatePassword(Long id, MemberDTO memberDTO) {
        Member prevMember = memberRepository.findById(id).orElseThrow(null);
        if (prevMember == null) {
            return prevMember;
        }
        String encodedPassword = bCryptPasswordEncoder.encode(memberDTO.getPassword());
        prevMember.setPassword(encodedPassword);

        return memberRepository.save(prevMember);
    }

    @Override
    public Member updateMemberStatus(Long id, MemberDTO memberDTO) throws Exception {
        Member prevMember = memberRepository.findById(id).orElse(null);
        if (prevMember == null) {
            throw new EntityNotFoundException("Kullanıcı bulunamadı!!");
        }
        prevMember.setMemberStatus(StatusEnum.PASSIVE);
        memberRepository.save(prevMember);
        return prevMember;
    }

    public Member update(Long id, MemberDTO memberDTO) throws Exception {

        Member prevMember = memberRepository.findById(id).orElse(null);
        if (prevMember == null) {
            throw new EntityNotFoundException("Kullanıcı bulunamadı!!");
        }
        if (memberRepository.existsByUserNameAndDeleted(memberDTO.getUserName(), false) && !id.equals(prevMember.getId())) {
            throw new Exception("Bu userName kullanılmakta Lütfen başka bir userName giriniz");
        }
        if (memberRepository.existsByEmail(memberDTO.getEmail()) && !id.equals(prevMember.getId())) {
            throw new Exception("Bu email zaten var");
        }

        prevMember.setEmail(memberDTO.getEmail());
        prevMember.setUserName(memberDTO.getUserName());
        prevMember.setPassword(memberDTO.getPassword());
        prevMember.setRoles(memberDTO.getRoles());
        prevMember.setPhoneNumber(memberDTO.getPhoneNumber());
        prevMember.setBirthDate(memberDTO.getBirthDate());
        prevMember.setMemberStatus(memberDTO.getMemberStatus());
        prevMember.setAdress(memberDTO.getAddress());
        prevMember.setFirstName(memberDTO.getFirstName());
        prevMember.setLastName(memberDTO.getLastName());
        prevMember.setDeleted(memberDTO.isDeleted());
        prevMember.setUpdateDate(new Date());

        return memberRepository.save(prevMember);
    }

    @Override
    public Member getById(Long id) throws Exception {

        Member member = memberRepository.findById(id).orElse(null);
        if (member == null) {
            throw new NotFoundException("Kullanıcı bulunamadı!");
        }
        return member;
    }

    @Override
    public Member delete(Long id) throws Exception {

        Member member = memberRepository.findById(id).orElse(null);
        if (member == null) {
            throw new NotFoundException("Kullanıcı bulunamadı!");
        }
        member.setDeleted(true);
        return member;
    }

    @Override
    public Member takeBook(Long bookId) throws Exception {

        Member currentUser = SecurityUtil.getCurrentUser();
        if (currentUser == null) {
            throw new NotFoundException("Kullanıcı bulunamadı!");
        }
        Book book = bookConverter.convertToEntity(bookService.getBookById(bookId));
        currentUser.setBooks(Collections.singletonList(book));

        return currentUser;
    }

    @Override
    public Member findByUserName(String userName) {

        return memberRepository.findByUserName(userName).orElseThrow(null);
    }
}
