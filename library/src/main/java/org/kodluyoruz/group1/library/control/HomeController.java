package org.kodluyoruz.group1.library.control;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
@RequiredArgsConstructor
public class HomeController {

    @GetMapping("/")
    public String home() {
     /*    if (principal == null) {
            return "/login";
        }*/
        return "fragments/header";
    }

    @GetMapping("/user")
    public String user() {
        return ("Welcome User ");
    }

    @GetMapping("/admin")
    public String admin() {
        return ("Welcome Admin ");
    }

    @GetMapping("/login")
    public String login() {
        return "/login";
    }
}