
package org.kodluyoruz.group1.library.control;

import lombok.RequiredArgsConstructor;
import org.kodluyoruz.group1.library.dto.AuthorDTO;
import org.kodluyoruz.group1.library.model.entities.Authors;
import org.kodluyoruz.group1.library.service.AuthorService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;
//
@RestController
@RequestMapping("/authors")
@RequiredArgsConstructor
public class AuthorController {

    private final AuthorService service;

    @PostMapping("/new")
    public Authors save(@RequestBody AuthorDTO dto){
        Authors author=service.saveAuthor(dto);
        return author;
    }

    @GetMapping
    public Collection<Authors> getAllActiveAuthors(){
      return service.getAllActive();
    }

    @GetMapping("/{name}")
    public Collection<Authors> getAllAuthorsByName(@PathVariable String name){
        return service.findByNameSurname(name);
    }

    @DeleteMapping("/{id}")
    public void deleteAuthor(@PathVariable Long id){
        service.deleteById(id);
        //hghhgg
    }

    @PutMapping("/update")
    public Authors updateAuthors(@RequestBody AuthorDTO dto){
        Authors authors=service.updateAuthor(dto);
        return authors;
    }

}
