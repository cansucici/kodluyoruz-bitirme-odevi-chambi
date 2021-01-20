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

    @Column(  length = 200, nullable = false)
    private String bookName;

    @Column(  length = 5, nullable = false)
    private Long pageNumber;

    @Column( length = 100, nullable = false)
    private String publisherName;

    @Column(  length = 50, nullable = false)
    private Integer editionNumber;

    @Column( unique = true, length = 50, nullable = false)
    private Long isbn;

    // TODO : dilleri Enum sınıfı olarak  ekledim.
    @Enumerated(value = EnumType.STRING)
    @Column( length = 15, nullable = false)
    private LanguagesEnum languagesEnum= LanguagesEnum.Türkçe;

    @Column(  length = 50, nullable = false)
    private String category;

    @Enumerated(value = EnumType.STRING)
    @Column( length = 7, nullable = false)
    private StatusEnum status = StatusEnum.ACTIVE;

    //TODO : bir kitabın birden çok yazarı olabilir ilişkisi

    @ManyToMany
    @JoinTable(name = "book_author",
    joinColumns = {@JoinColumn(name = "book_id", referencedColumnName = "id")},
    inverseJoinColumns ={@JoinColumn(name = "author_id", referencedColumnName = "id")} )
    private List<Author> authors;




    //TODO: Bu ilişkiyi bir daha kontrol edeceğim, muhammed
    @OneToOne
    @JoinTable(name = "book_member",
            joinColumns = {@JoinColumn(name = "book_id", referencedColumnName = "id")},
            inverseJoinColumns ={@JoinColumn(name = "member_id", referencedColumnName = "id")} )
    private Member member;


}
