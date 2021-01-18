package org.kodluyoruz.group1.library.model.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.kodluyoruz.group1.library.model.enums.StatusEnum;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "book")
public class Book extends BaseEntity {

    @Column(name = "book_name", unique = false, length = 200, nullable = false)
    private String bookName;

    @Column(name = "page_number", unique = false, length = 5, nullable = false)
    private Long pageNumber;

    @Column(name = "publisher", unique = false, length = 100, nullable = false)
    private String publisherName;

    @Column(name = "edition_number", unique = false, length = 50, nullable = false)
    private Integer editionNumber;

    @Column(name = "isbn", unique = true, length = 50, nullable = false)
    private Long isbn;

    @Column(name = "language", unique = false, length = 50, nullable = false)
    private String language;

    @Column(name = "category", unique = false, length = 50, nullable = false)
    private String category;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "book_status", length = 7, nullable = false)
    private StatusEnum status = StatusEnum.ACTIVE;

    //Bu ilişki OK , muhammed
    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;

    //TODO: Bu ilişkiyi bir daha kontrol edeceğim, muhammed
    @OneToOne
    @JoinTable(name = "book_member",
            joinColumns = {@JoinColumn(name = "book_id", referencedColumnName = "id"),

            },
            inverseJoinColumns = {
                    @JoinColumn(name = "member_id", referencedColumnName = "id")
            }
    )
    private Member member;


}
