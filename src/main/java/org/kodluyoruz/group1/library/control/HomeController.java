package org.kodluyoruz.group1.library.control;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "fragments/header";
    }

    @GetMapping("/login")
    public String login() {
        return "/login";
    }

    @GetMapping("/error")
    public String error() {
        return "error/error_page";
    }

}