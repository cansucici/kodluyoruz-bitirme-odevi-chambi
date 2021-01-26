package org.kodluyoruz.group1.library.model.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.kodluyoruz.group1.library.model.enums.LanguagesEnum;
import org.kodluyoruz.group1.library.model.enums.StatusEnum;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
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
    @Column(length = 15)
    private LanguagesEnum languagesEnum = LanguagesEnum.TURKISH;

    @Column(length = 50)
    private String category;

    @Enumerated(value = EnumType.STRING)
    @Column(length = 7)
    private StatusEnum status = StatusEnum.ACTIVE;

    @ManyToMany
    @JoinTable(name = "book_author",
            joinColumns = {@JoinColumn(name = "book_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "author_id", referencedColumnName = "id")})
    private List<Author> authors;


    //TODO: Bu ilişkiyi bir daha kontrol edeceğim, muhammed
    @ManyToOne
    @JoinTable(name = "book_member",
            joinColumns = {@JoinColumn(name = "book_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "member_id", referencedColumnName = "id")})
    private Member member;


}
