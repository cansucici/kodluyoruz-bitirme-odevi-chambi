package org.kodluyoruz.group1.library.control;

import javax.validation.Valid;

import org.kodluyoruz.group1.library.dto.AuthorDTO;
import org.kodluyoruz.group1.library.service.IAuthorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class AuthorController {

    private final IAuthorService authorService;

    @GetMapping("/authorslist")
    public String getAllActiveAuthors(Model model) {

        model.addAttribute("listAuthors", authorService.getAllActive());
        return "author_list";
    }

    @GetMapping("/saveAuthor")
    public String getCreateAuthor(Model model) {

        model.addAttribute("authorDTO", new AuthorDTO());
        return "add_author";
    }

    @PostMapping("/saveAuthor")
    public String postCreateBook(@Valid AuthorDTO authorDTO) {

        authorService.save(authorDTO);
        return "redirect:/authorslist";
    }

    @GetMapping("/updateAuthor/{id}")
    public String getUpdateAuthor(@PathVariable Long id, Model model) {

        AuthorDTO authorDTO = (authorService.getAuthorById(id));
        model.addAttribute("authorDTO", authorDTO);
        return "update_author";
    }

    @PostMapping("/updateAuthor/{id}")
    public String postUpdateAuthor(@PathVariable Long id, AuthorDTO authorDTO) {

        authorService.update(id, authorDTO);
        return "redirect:/authorslist";
    }

    @PostMapping("/deleteAuthor/{id}")
    public String deleteAuthor(@PathVariable Long id) {

        authorService.deleteById(id);
        return "redirect:/authorslist";
    }

    // @GetMapping("/{nameSurname}")
    // public Collection<Author> getAuthorsByNameSurname(@PathVariable String
    // nameSurname) {
    // return authorService.findByNameSurname(nameSurname);
    // }
}