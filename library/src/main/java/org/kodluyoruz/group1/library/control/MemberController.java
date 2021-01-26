package org.kodluyoruz.group1.library.control;

import lombok.RequiredArgsConstructor;
import org.kodluyoruz.group1.library.dto.MemberDTO;
import org.kodluyoruz.group1.library.model.entities.Member;
import org.kodluyoruz.group1.library.service.MemberService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller("/member")
@RequiredArgsConstructor
public class MemberController {

    MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping
    public List<Member> getAll(){
        return memberService.getAll();
    }

    @PostMapping("/new-record")
    public Member create (@RequestBody @Valid MemberDTO memberDTO) throws Exception {
        return memberService.create(memberDTO);
    }

    @PutMapping
    public Member update(Long id,@RequestBody @Valid Member member) throws Exception{
        return memberService.update(id,member);
    }

    @PutMapping("/new-password/{id}")
    ResponseEntity<Member> password(@RequestBody @Valid Member member, @PathVariable Long id)
    {
        // Assert.notNull(member, "boş gönderemezsin");
        Member m = memberService.updatePassword(id, member);
        return ResponseEntity.status(HttpStatus.OK).body(m);
    }

    @GetMapping("/{id}")
    public Member getById(@PathVariable Long id) throws Exception{
        return memberService.getById(id);
    }

    @PutMapping("/delete/{id}")
    public Member delete(@PathVariable Long id) throws Exception{
        return memberService.delete(id);
    }

    @PutMapping("/member-status/{id}")
    public Member updateMemberStatus(@PathVariable Long id, @RequestBody @Valid Member member) throws Exception{
        return memberService.updateMemberStatus(id , member);
    }

    @PutMapping("/take-book/{id}")
    public Member takeBook(@PathVariable Long bookid)throws Exception{
        return memberService.takeBook(bookid);
    }



}
