package org.kodluyoruz.group1.library.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.kodluyoruz.group1.library.model.entities.Book;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthorDTO extends BaseDTO {

    @NotEmpty(message = "isim soyisim alanı boş olamaz.")
    @NotNull(message = "isim soyisim alanı boş olamaz. ")
    private String nameSurname;

    private String about;

    private List<Book> books;
}
