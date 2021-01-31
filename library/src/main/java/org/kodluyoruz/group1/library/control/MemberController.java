package org.kodluyoruz.group1.library.control;

import lombok.RequiredArgsConstructor;
import org.kodluyoruz.group1.library.dto.MemberDTO;
import org.kodluyoruz.group1.library.model.entities.Member;
import org.kodluyoruz.group1.library.service.IMemberService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class MemberController {

    private final IMemberService memberService;

    @GetMapping("/memberlist")
    public String  getAll(Model model) {
        List<Member> memberList = memberService.getAll();
        model.addAttribute("listmember", memberList);
        return "member_list";
    }

    @GetMapping("/new-record")
    public String getCreateMember(Model model) {
        model.addAttribute("memberDTO", new MemberDTO());
        return "register";
    }

    @PostMapping("/new-record")
    public String postCreateMember(@ModelAttribute("memberDTO")  MemberDTO memberDTO){
        memberService.create(memberDTO);
        return "redirect:/login";
    }


    @GetMapping("/member/update/{id}")
    public String getupdateMember(@PathVariable Long id, Model model) {
        model.addAttribute("memberDTO", memberService.getById(id));

        return "update_member";
    }

    @PostMapping("/member/update/{id}")
    public String postUpdateMember(@PathVariable Long id, MemberDTO memberDTO){
        memberService.update(id,memberDTO);
        return "redirect:/update_member";
    }


    @PutMapping("/new-password/{id}")
    ResponseEntity<Member> password(@RequestBody @Valid MemberDTO memberDTO, @PathVariable Long id) {
        Member m = memberService.updatePassword(id, memberDTO);
        return ResponseEntity.status(HttpStatus.OK).body(m);
    }

    @GetMapping("/member/{id}")
    public Member getById(@PathVariable Long id)  {
        return memberService.getById(id);
    }

    @PostMapping("/member/delete/{id}")
    public String deleteMember(@PathVariable Long id)  {
        memberService.delete(id);
        return "redirect:/memberlist";
    }

    @PostMapping("/member-status/{id}")
    public String updateMemberStatus(@PathVariable Long id)  {
        memberService.updateMemberStatus(id);
        return "redirect:/memberlist";
    }

    @PostMapping("/take-book/{id}")
    public String takeBook(@PathVariable Long id)  {
         memberService.takeBook(id);
         return "redirect:/booklist";
    }

}
