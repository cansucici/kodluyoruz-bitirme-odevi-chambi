package org.kodluyoruz.group1.library.control;

import lombok.RequiredArgsConstructor;
import org.kodluyoruz.group1.library.dto.AuthorDTO;
import org.kodluyoruz.group1.library.model.entities.Authors;
import org.kodluyoruz.group1.library.service.AuthorService;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/*
@RestController
@RequiredArgsConstructor
public class AuthorController {

    private final AuthorService service;

    @PostMapping("/newAuthor")
    public Authors newAuthor(@RequestBody AuthorDTO authorDTO){

            return service.save(authorDTO);

    }
}
*/