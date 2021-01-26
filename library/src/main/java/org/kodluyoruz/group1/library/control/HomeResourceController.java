package org.kodluyoruz.group1.library.control;

import lombok.RequiredArgsConstructor;
import org.kodluyoruz.group1.library.dao.MemberRepository;
import org.kodluyoruz.group1.library.model.entities.Member;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@Controller
@RequiredArgsConstructor
public class HomeResourceController {


    @GetMapping("/")
    public String home(){
        return "header";
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