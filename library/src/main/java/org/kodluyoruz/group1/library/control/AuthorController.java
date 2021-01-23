
package org.kodluyoruz.group1.library.control;

import lombok.RequiredArgsConstructor;
import org.kodluyoruz.group1.library.dto.AuthorDTO;
import org.kodluyoruz.group1.library.model.entities.Author;
import org.kodluyoruz.group1.library.service.AuthorService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.Collection;


@RestController
@RequestMapping("/authors")
@RequiredArgsConstructor
public class AuthorController {

    private final AuthorService authorService;

    @PostMapping
    public Author save(@RequestBody @Validated AuthorDTO dto) {
        return authorService.save(dto);

    }

    @GetMapping
    public Collection<Author> getAllActiveAuthors() {
        return authorService.getAllActive();
    }

    @GetMapping("/{nameSurname}")
    public Collection<Author> getAuthorsByNameSurname(@PathVariable String nameSurname) {
        return authorService.findByNameSurname(nameSurname);
    }

    @PutMapping
    public Author updateAuthors(@RequestBody @Validated AuthorDTO dto) {
        return authorService.update(dto);
    }

    @DeleteMapping("/{id}")
    public void deleteAuthor(@PathVariable Long id) {
        authorService.deleteById(id);
    }

}