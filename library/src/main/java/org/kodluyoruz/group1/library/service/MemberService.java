package org.kodluyoruz.group1.library.service;

import javassist.NotFoundException;
import org.kodluyoruz.group1.library.converter.BookConverter;
import org.kodluyoruz.group1.library.converter.MemberConverter;
import org.kodluyoruz.group1.library.dao.MemberRepository;
import org.kodluyoruz.group1.library.dto.MemberDTO;
import org.kodluyoruz.group1.library.model.entities.Book;
import org.kodluyoruz.group1.library.model.entities.Member;
import org.kodluyoruz.group1.library.model.enums.StatusEnum;
import org.kodluyoruz.group1.library.utils.SecurityUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.EntityNotFoundException;
import java.util.Collections;
import java.util.Date;
import java.util.List;


public class MemberService implements IMemberService {

    private final MemberRepository memberRepository;
    private final BookService bookService;
    private final MemberConverter memberConverter;
    private final BookConverter bookConverter;

    public MemberService(MemberRepository memberRepository,
                         BCryptPasswordEncoder bCryptPasswordEncoder,
                         MemberConverter memberConverter, BookService bookService,
                         BookConverter bookConverter) {
        this.memberRepository = memberRepository;
        this.memberConverter = memberConverter;
        this.bookService = bookService;
        this.bookConverter = bookConverter;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;

    }


    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

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
    public Member updatePassword(Long id, Member member) {
        Member prevmember = memberRepository.findById(id).orElseThrow(null);
        if (prevmember == null) {
            return prevmember;
        }
        String encodedPassword = bCryptPasswordEncoder.encode(member.getPassword());
        prevmember.setPassword(encodedPassword);

        return memberRepository.save(prevmember);
    }

    @Override
    public Member updateMemberStatus(Long id, Member member) throws Exception {
        Member prevmember = memberRepository.findById(id).orElse(null);
        if (prevmember == null) {
            throw new EntityNotFoundException("Kullanıcı bulunamadı!!");
        }
        prevmember.setMemberStatus(StatusEnum.PASSIVE);
        memberRepository.save(prevmember);
        return prevmember;
    }

    public Member update(Long id, Member member) throws Exception {
        Member prevmember = memberRepository.findById(id).orElse(null);
        if (prevmember == null) {
            throw new EntityNotFoundException("Kullanıcı bulunamadı!!");
        }
        if (memberRepository.existsByUserNameAndDeleted(member.getUserName(), false) && id != prevmember.getId()) {
            throw new Exception("Bu userName kullanılmakta Lütfen başka bir userName giriniz");
        }
        if (memberRepository.existsByEmail(member.getEmail()) && id != prevmember.getId()) {
            throw new Exception("Bu email zaten var");
        }
        prevmember.setEmail(member.getEmail());
        prevmember.setUserName(member.getUserName());
        prevmember.setPassword(member.getPassword());
        prevmember.setRoles(member.getRoles());
        prevmember.setPhoneNumber(member.getPhoneNumber());
        prevmember.setBirthDate(member.getBirthDate());
        prevmember.setMemberStatus(member.getMemberStatus());
        prevmember.setAdress(member.getAdress());
        prevmember.setFirstName(member.getFirstName());
        prevmember.setLastName(member.getLastName());
        prevmember.setDeleted(member.isDeleted());

        prevmember.setUpdateDate(new Date());

        return memberRepository.save(prevmember);
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
