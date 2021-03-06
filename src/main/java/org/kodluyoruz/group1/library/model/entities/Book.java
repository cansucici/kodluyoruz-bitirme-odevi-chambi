package org.kodluyoruz.group1.library.model.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.kodluyoruz.group1.library.model.enums.LanguagesEnum;
import org.kodluyoruz.group1.library.model.enums.StatusEnum;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@EqualsAndHashCode
@Table(name = "book")
public class Book extends BaseEntity {

    @Column(length = 200, nullable = false)
    private String bookName;

    @Column(length = 5)
    private Long pageNumber;

    @Column(length = 100)
    private String publisherName;

    @Column(length = 50)
    private Integer editionNumber;

    @Column(unique = true, length = 50)
    private Long isbn;

    @Enumerated(value = EnumType.STRING)
    @Column(length = 25)
    private LanguagesEnum languagesEnum;

    @Column(length = 50)
    private String category;

    @Enumerated(value = EnumType.STRING)
    @Column(length = 10)
    private StatusEnum status;

    @ManyToMany
    @JoinTable(name = "book_author", joinColumns = @JoinColumn(name = "book_id"), inverseJoinColumns = @JoinColumn(name = "author_id"))
    private List<Author> authors = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;
}
