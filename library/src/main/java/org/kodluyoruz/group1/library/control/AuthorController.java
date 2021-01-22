
package org.kodluyoruz.group1.library.control;

import lombok.RequiredArgsConstructor;
import org.kodluyoruz.group1.library.dto.AuthorDTO;
import org.kodluyoruz.group1.library.model.entities.Author;
import org.kodluyoruz.group1.library.service.AuthorService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

<<<<<<< HEAD
=======

>>>>>>> 5e511ea (author's changed)
@RestController
@RequestMapping("/authors")
@RequiredArgsConstructor
public class AuthorController {

    private final AuthorService authorService;

    @PostMapping
    public Author save(@RequestBody AuthorDTO dto) {
<<<<<<< HEAD
        return authorService.saveAuthor(dto);
=======
        return service.saveAuthor(dto);
>>>>>>> 5e511ea (author's changed)
    }

    @GetMapping
    public Collection<Author> getAllActiveAuthors() {
        return authorService.getAllActive();
    }

<<<<<<< HEAD
    @GetMapping("/{name}")
    public Author getAuthorsByName(@PathVariable String nameSurname) {
        return authorService.findByNameSurname(nameSurname);
=======

    //iki variable tanımlayacağım
    @GetMapping("/{name}{surname}")
    public Collection<Author> getAllAuthorsByName(@PathVariable String name,String surname) {
        return service.findByNameSurname(name,surname);
>>>>>>> 5e511ea (author's changed)
    }

    @DeleteMapping("/{id}")
    public void deleteAuthor(@PathVariable Long id) {
<<<<<<< HEAD
        authorService.deleteById(id);
=======
        service.deleteById(id);
>>>>>>> 5e511ea (author's changed)
    }

    @PutMapping
    public Author updateAuthors(@RequestBody AuthorDTO dto) {
        return authorService.updateAuthor(dto);
    }
}
