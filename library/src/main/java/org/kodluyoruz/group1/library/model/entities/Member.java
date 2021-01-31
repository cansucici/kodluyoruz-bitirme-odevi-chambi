package org.kodluyoruz.group1.library.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.Type;
import org.kodluyoruz.group1.library.model.enums.StatusEnum;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "member")
public class Member extends BaseEntity {

    @Column(length = 100, nullable = false)
    private String firstName;

    @Column(length = 100, nullable = false)
    private String lastName;

    @Column(unique = true, length = 100, nullable = false)
    private String userName;

    @Column(unique = true, length = 100, nullable = false)
    @Email(message = "Lütfen email adresinizi doğru giriniz.")
    private String email;

    @Column(length = 6, nullable = false)
    private String password;

    @Column(unique = true, length = 100, nullable = false)
    private String phoneNumber;

    @Type(type = "text")
    private String adress;


    @Enumerated(value = EnumType.STRING)
    @Column(length = 7, nullable = false)
    private StatusEnum memberStatus;

    @JsonIgnore
    @ManyToMany
    @JoinTable(name = "member_role", joinColumns = @JoinColumn(name = "member_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private List<Role> roles = new ArrayList<>();

    @JsonIgnore
    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "member")
    private List<Book> books = new ArrayList<>();
}