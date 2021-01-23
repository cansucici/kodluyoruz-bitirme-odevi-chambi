package org.kodluyoruz.group1.library.control;

import lombok.RequiredArgsConstructor;
import org.kodluyoruz.group1.library.dao.MemberRepository;
import org.kodluyoruz.group1.library.model.entities.Member;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class HomeResourceController {

   private final MemberRepository memberRepository;
  /*  private final AuthorServiceImpl service;
    @PostMapping("/authors")
    public Authors save(@ResponseBody AuthorDTO dto){
        Authors author=service.save(dto);
        return author;
    }
*/

    @PostMapping("/newrecord")
    public Member member (@RequestBody Member member){
        return memberRepository.save(member);
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