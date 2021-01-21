
package org.kodluyoruz.group1.library.control;

import lombok.RequiredArgsConstructor;
import org.kodluyoruz.group1.library.dto.AuthorDTO;
import org.kodluyoruz.group1.library.model.entities.Author;
import org.kodluyoruz.group1.library.service.AuthorService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/authors")
@RequiredArgsConstructor
public class AuthorController {

    private final AuthorService authorService;

    @PostMapping
    public Author save(@RequestBody AuthorDTO dto) {
        return authorService.saveAuthor(dto);
    }

    @GetMapping
    public Collection<Author> getAllActiveAuthors() {
        return authorService.getAllActive();
    }

    @GetMapping("/{name}")
    public Author getAuthorsByName(@PathVariable String nameSurname) {
        return authorService.findByNameSurname(nameSurname);
    }

    @DeleteMapping("/{id}")
    public void deleteAuthor(@PathVariable Long id) {
        authorService.deleteById(id);
    }

    @PutMapping
    public Author updateAuthors(@RequestBody AuthorDTO dto) {
        return authorService.updateAuthor(dto);
    }
}
