package org.kodluyoruz.group1.library.control;

import lombok.RequiredArgsConstructor;
import org.kodluyoruz.group1.library.dto.MemberDTO;
import org.kodluyoruz.group1.library.model.entities.Member;
import org.kodluyoruz.group1.library.service.IMemberService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class MemberController {

    private final IMemberService memberService;

    @GetMapping("/memberlist")
    public String getAll(Model model) {
        List<Member> memberList = memberService.getAll();
        model.addAttribute("listmember", memberList);
        return "member_list";
    }

    @GetMapping("/new-member")
    public String getCreateMember(Model model) {
        model.addAttribute("memberDTO", new MemberDTO());
        return "register";
    }

    @PostMapping("/new-member")
    public String postCreateMember(@ModelAttribute("memberDTO") MemberDTO memberDTO) {
        memberService.create(memberDTO);
        return "redirect:/login";
    }

    @GetMapping("/member/update/{userName}")
    public String getUpdateMember(@PathVariable String userName, Model model) {
        model.addAttribute("memberDTO", memberService.findByUserName(userName));

        return "update_member";
    }

    @PostMapping("/member/update/{userName}")
    public String postUpdateMember(@PathVariable String userName, MemberDTO memberDTO) {
        memberService.update(userName, memberDTO);
        return "redirect:/";
    }

    @GetMapping("/new-password")
    public String getUpdatePassword(Model model) {
        model.addAttribute("memberDTO", new MemberDTO());
        return "update_password";
    }

    @PostMapping("/new-password")
    public String postUpdatePassword(MemberDTO memberDTO) {
        memberService.updatePassword(memberDTO);
        return "redirect:/login";
    }

    @GetMapping("/member/{id}")
    public Member getById(@PathVariable Long id) {
        return memberService.getById(id);
    }

    @PostMapping("/member/delete/{id}")
    public String deleteMember(@PathVariable Long id) {
        memberService.delete(id);
        return "redirect:/memberlist";
    }

    @PostMapping("/member-status/{id}")
    public String updateMemberStatus(@PathVariable Long id) {
        memberService.updateMemberStatus(id);
        return "redirect:/memberlist";
    }

    @PostMapping("/take-book/{id}")
    public String takeBook(@PathVariable Long id) {
        memberService.takeBook(id);
        return "redirect:/booklist";
    }

    @PostMapping("/give-book/{id}")
    public String giveBook(@PathVariable Long id) {
        memberService.giveBook(id);
        return "redirect:/booklist";
    }

}
