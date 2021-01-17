package org.kodluyoruz.group1.library.model.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.kodluyoruz.group1.library.model.enums.StatusEnum;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "BOOK")
public class Books extends BaseEntity {

    @Column(name = "Book_Name", unique = false, length = 200, nullable = false)
    private String bookName;


    @Column(name = "Page_Number", unique = false, length = 5, nullable = false)
    private Long pageNumber;

    @Column(name = "Publisher", unique = false, length = 100, nullable = false)
    private String publisherName;

    @Column(name = "Edition_Number", unique = false, length = 50, nullable = false)
    private Integer editionNumber;

    @Column(name = "ISBN", unique = true, length = 50, nullable = false)
    private Long isbn;

    @Column(name = "Language", unique = false, length = 50, nullable = false)
    private String language;

    @Column(name = "Category", unique = false, length = 50, nullable = false)
    private String category;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "Book_Status", length = 7, nullable = false)
    private StatusEnum bookStatus = StatusEnum.ACTIVE;

    @OneToMany(mappedBy = "books")
    private List<Authors> authors;

}
