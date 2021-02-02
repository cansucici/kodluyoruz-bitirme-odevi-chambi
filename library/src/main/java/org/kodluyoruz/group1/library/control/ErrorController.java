package org.kodluyoruz.group1.library.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ErrorController {

    @GetMapping("/403")
    public  String unauthorizedError (){

        return "error/403";
    }
}
