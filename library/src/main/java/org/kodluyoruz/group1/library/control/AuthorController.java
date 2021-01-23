
package org.kodluyoruz.group1.library.control;

import lombok.RequiredArgsConstructor;
import org.kodluyoruz.group1.library.dto.AuthorDTO;
import org.kodluyoruz.group1.library.model.entities.Author;
import org.kodluyoruz.group1.library.service.AuthorService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

//
@RestController
@RequestMapping("/authors")
@RequiredArgsConstructor
public class AuthorController {

    private final AuthorService service;

    @PostMapping("/new")
    public Author save(@RequestBody AuthorDTO dto) {
        Author author = service.saveAuthor(dto);
        return author;
    }

    @GetMapping
    public Collection<Author> getAllActiveAuthors() {
        return service.getAllActive();
    }

    @GetMapping("/{name}")
    public Collection<Author> getAllAuthorsByName(@PathVariable String name) {
        return service.findByNameSurname(name);
    }

    @DeleteMapping("/{id}")
    public void deleteAuthor(@PathVariable Long id) {
        service.deleteById(id);
        //hghhgg
    }

    @PutMapping("/update")
    public Author updateAuthors(@RequestBody AuthorDTO dto) {
        Author author = service.updateAuthor(dto);
        return author;
    }
}
