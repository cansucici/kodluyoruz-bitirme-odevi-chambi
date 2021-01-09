package org.kodluyoruz.group1.library.control;

import org.kodluyoruz.group1.library.dao.MemberRepository;
import org.kodluyoruz.group1.library.model.entities.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeResourceController {


    @Autowired
    MemberRepository memberRepository;

    @PostMapping("/newrecord")
    public Member member (@RequestBody Member member){
        Member newrecord = memberRepository.save(member);
        return newrecord;
    }


    @GetMapping("/")
    public String home(){
        return ("Welcome ");
    }

    @GetMapping("/user")
    public String user(){
        return ("Welcome User ");
    }

    @GetMapping("/admin")
    public String admin(){
        return ("Welcome Admin ");
    }

}
