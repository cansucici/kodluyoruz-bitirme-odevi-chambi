package org.kodluyoruz.group1.library.service.impl;

import lombok.RequiredArgsConstructor;
import org.kodluyoruz.group1.library.converter.BookConverter;
import org.kodluyoruz.group1.library.converter.MemberConverter;
import org.kodluyoruz.group1.library.dao.BookRepository;
import org.kodluyoruz.group1.library.dao.MemberRepository;
import org.kodluyoruz.group1.library.dao.RoleRepository;
import org.kodluyoruz.group1.library.dto.MemberDTO;
import org.kodluyoruz.group1.library.exceptions.AlreadyExistException;
import org.kodluyoruz.group1.library.exceptions.MemberNotFoundException;
import org.kodluyoruz.group1.library.model.entities.Book;
import org.kodluyoruz.group1.library.model.entities.Member;
import org.kodluyoruz.group1.library.model.entities.Role;
import org.kodluyoruz.group1.library.model.enums.StatusEnum;
import org.kodluyoruz.group1.library.service.IMemberService;
import org.kodluyoruz.group1.library.utils.SecurityUtil;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService implements IMemberService {

    private final BookService bookService;
    private final MemberRepository memberRepository;
    private final RoleRepository roleRepository;
    private final BookRepository bookRepository;
    private final MemberConverter memberConverter;
    private final BookConverter bookConverter;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public List<Member> getAll() {
        return memberRepository.findAllByDeletedIsFalse();
    }

    @Override
    public Member create(MemberDTO memberDTO) {
        String encodedPassword = bCryptPasswordEncoder.encode(memberDTO.getPassword());
        memberDTO.setPassword(encodedPassword);

        if (memberRepository.existsByUserNameAndDeleted(memberDTO.getUserName(), false)) {
            throw new AlreadyExistException("Bu username kullanılmakta!");
        }
        if (memberRepository.existsByEmailAndDeleted(memberDTO.getEmail(), false)) {
            throw new AlreadyExistException("Bu email kullanılmakta, Lütfen başka bir email ile kayıt olunuz!!");
        }
        memberDTO.setMemberStatus(StatusEnum.ACTIVE);

        Role roleUser = roleRepository.findByRoleName("ROLE_USER");
        List<Role> roles = Collections.singletonList(roleUser);

        Member member = memberConverter.convert(memberDTO, roles);
        return memberRepository.save(member);
    }

    @Override
    public Member updatePassword(MemberDTO memberDTO) {

        Member prevMember = memberRepository.findByUserName(memberDTO.getUserName()).orElseThrow(null);
        if (prevMember == null) {
            throw new MemberNotFoundException("Kullanıcı bulunamadı!");
        }
        String encodedPassword = bCryptPasswordEncoder.encode(memberDTO.getPassword());
        prevMember.setPassword(encodedPassword);

        return memberRepository.save(prevMember);
    }

    @Override
    public Member updateMemberStatus(Long id) {
        Member prevMember = memberRepository.findById(id).orElse(null);
        if (prevMember == null) {
            throw new MemberNotFoundException("Kullanıcı bulunamadı!!");
        }
        if (prevMember.getMemberStatus() == StatusEnum.ACTIVE) {
            prevMember.setMemberStatus(StatusEnum.PASSIVE);
        } else {
            prevMember.setMemberStatus(StatusEnum.ACTIVE);
        }
        memberRepository.save(prevMember);
        return prevMember;
    }

    @Override
    public Member delete(Long id) {

        Member member = memberRepository.findById(id).orElse(null);
        if (member == null) {
            throw new MemberNotFoundException("Kullanıcı bulunamadı!");
        }
        member.setDeleted(true);
        memberRepository.save(member);
        return member;
    }

    public Member update(String userName, MemberDTO memberDTO) {

        Member prevMember = memberRepository.findByUserName(userName).orElse(null);
        if (prevMember == null) {
            throw new MemberNotFoundException("Kullanıcı bulunamadı!!");
        }
        if (memberRepository.existsByUserNameAndDeleted(memberDTO.getUserName(), false)
                && !userName.equals(prevMember.getUserName())) {
            throw new AlreadyExistException("Bu userName kullanılmakta Lütfen başka bir userName giriniz");
        }
        if (memberRepository.existsByEmailAndDeleted(memberDTO.getEmail(), false) && !userName.equals(prevMember.getUserName())) {
            throw new AlreadyExistException("Bu email zaten var!");
        }

        prevMember.setEmail(memberDTO.getEmail());
        prevMember.setPhoneNumber(memberDTO.getPhoneNumber());
        prevMember.setAdress(memberDTO.getAdress());
        prevMember.setFirstName(memberDTO.getFirstName());
        prevMember.setLastName(memberDTO.getLastName());

        return memberRepository.save(prevMember);
    }

    @Override
    public Member getById(Long id) {

        Member member = memberRepository.findById(id).orElse(null);
        if (member == null) {
            throw new MemberNotFoundException("Kullanıcı bulunamadı!");
        }
        return member;
    }

    @Override
    public Book takeBook(Long bookId) {

        Member currentUser = findByUserName(SecurityUtil.getCurrentUsername());
        if (currentUser == null) {
            throw new MemberNotFoundException("Kullanıcı bulunamadı!");
        }

        Book book = bookConverter.convertToEntity(bookService.getBookById(bookId));
        book.setStatus(StatusEnum.PASSIVE);
        book.setMember(currentUser);
        return bookRepository.save(book);
    }

    public Book giveBook(Long bookId) {

        Member currentUser = findByUserName(SecurityUtil.getCurrentUsername());
        if (currentUser == null) {
            throw new MemberNotFoundException("Kullanıcı bulunamadı!");
        }

        Book book = bookConverter.convertToEntity(bookService.getBookById(bookId));
        if (currentUser.getBooks().contains(book)) {
            book.setStatus(StatusEnum.ACTIVE);
            book.setMember(null);
        }
        return bookRepository.save(book);
    }


    @Override
    public Member findByUserName(String userName) {
        return memberRepository.findByUserName(userName).orElseThrow(MemberNotFoundException::new);
    }
}
