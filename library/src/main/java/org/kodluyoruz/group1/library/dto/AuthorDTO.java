package org.kodluyoruz.group1.library.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AuthorDTO extends BaseDTO{

    //private Long id;
    private String nameSurname;
    private String about;

//    private Date createDate;
//    private Date updateDate;

}
