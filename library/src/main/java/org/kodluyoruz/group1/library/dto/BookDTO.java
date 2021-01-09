package org.kodluyoruz.group1.library.dto;

import lombok.*;
import org.kodluyoruz.group1.library.model.enums.BookStatusEnum;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookDTO extends BaseDTO {


    //private Long id;
    private String bookName;
    private Long authorId;
    private Long pageNumber;
    private String publisherName;
    private Integer editionNumber;
    private Long isbn;
    private String language;
    private String category;
    //private Date createDate;
   // private Date updateDate;
    private BookStatusEnum bookStatus;
}
