package org.kodluyoruz.group1.library.dto;

import java.util.List;

import javax.validation.constraints.NotEmpty;

import org.kodluyoruz.group1.library.model.entities.Book;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AuthorDTO extends BaseDTO {

    @NotEmpty(message="isim soyisim alanı boş olamaz.")
    private String nameSurname;

    private String about;

    private List<Book> books;

}
