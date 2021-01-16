package org.kodluyoruz.group1.library.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import lombok.*;
import net.bytebuddy.implementation.bind.annotation.Empty;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "AUTHOR")
public class Authors extends BaseEntity {

    @Column(name = "Name_Surname",unique = false , length = 100 , nullable = false)
    private String nameSurname;

    @Lob
    @Type(type = "text")
    @Column(name = "About")
    private String about;

    @JsonIgnore //Belirtilen alanın json'a çevrilmemesini sağlar
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "book_author",
            joinColumns = @JoinColumn(name = "book_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "author_id",
                    referencedColumnName = "id"))

    private List<Books> books;

}
