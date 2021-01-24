package org.kodluyoruz.group1.library.control;

import lombok.RequiredArgsConstructor;
import org.kodluyoruz.group1.library.dto.AuthorDTO;
import org.kodluyoruz.group1.library.model.entities.Author;
import org.kodluyoruz.group1.library.service.AuthorService;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.Collection;
import org.springframework.stereotype.Controller;


@Controller
@RequiredArgsConstructor
public class AuthorController {

    private final AuthorService authorService;

    @PostMapping("/saveAuthor")
    public String save(@ModelAttribute("authorDTO") @Validated AuthorDTO dto) {
        authorService.save(dto);
        return  "redirect:/listAuthors";
    }

    @GetMapping("/listAuthors")
    public String getAllActiveAuthors(Model model) {
        model.addAttribute("listAuthors", authorService.getAllActive());
        return "author_list";
    }

    @GetMapping("/{nameSurname}")
    public Collection<Author> getAuthorsByNameSurname(@PathVariable String nameSurname) {
        return authorService.findByNameSurname(nameSurname);
    }

//    @PutMapping("/authors")
//    public String updateAuthors(@ModelAttribute @Validated AuthorDTO dto) {
//        authorService.update(dto);
//        return "redirect:/listAuthors";
//
//    }

    @DeleteMapping("/authors/{id}")
    public void deleteAuthor(@PathVariable Long id) {
        authorService.deleteById(id);
    }
}