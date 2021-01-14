package org.kodluyoruz.group1.library.control;

import lombok.RequiredArgsConstructor;
import org.kodluyoruz.group1.library.dao.MemberRepository;
import org.kodluyoruz.group1.library.dto.AuthorDTO;
import org.kodluyoruz.group1.library.model.entities.Authors;
import org.kodluyoruz.group1.library.model.entities.Member;
import org.kodluyoruz.group1.library.service.AuthorService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequiredArgsConstructor
public class HomeResourceController {

   private final MemberRepository memberRepository;
    private final AuthorService authorService;

    @PostMapping("/newrecord")
    public Member member (@RequestBody Member member){
        Member newrecord = memberRepository.save(member);
        return newrecord;
    }

    @GetMapping("/")
    public String home(){
        return ("Welcome ");
    }

    @GetMapping("/user")
    public String user(){
        return ("Welcome User ");
    }

    @GetMapping("/admin")
    public String admin(){
        return ("Welcome Admin ");
    }



    //AUTHOR CONTROLLER
    //end-pointleri güncelle


    //GETALL
    @GetMapping("/authors")
    public Collection<Authors> allAuthors(){
        return authorService.getAllAuthors();
    }

    @GetMapping("/{authorId")
    public Authors getOneByNameSurname(@PathVariable("authorId") String nameSurname){

        Authors author= authorService.getByNameSurname(nameSurname);
        return author;
    }


    //POST NEW AUTHOR
    @PostMapping("/authors/new")
    public Authors newAuthor(@RequestBody AuthorDTO authorDTO){

        return authorService.save(authorDTO);

    }
/*
    @DeleteMapping("/{authorId")
    public Authors delete(@PathVariable("authorId") Long id){
        authorService.deleteById(id);

    }

*/
}
