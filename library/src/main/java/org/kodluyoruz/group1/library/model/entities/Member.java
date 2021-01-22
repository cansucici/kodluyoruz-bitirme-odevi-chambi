package org.kodluyoruz.group1.library.model.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Type;
import org.kodluyoruz.group1.library.model.enums.StatusEnum;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "MEMBER")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column( length = 100 , nullable = false)
    private String firstName;

    @Column(length = 100 , nullable = false)
    private String lastName;

    @Column(unique = true , length = 100 , nullable = false)
    private String userName;

    @Column(unique = true , length = 100 , nullable = false)
    @Email(message = "Lütfen email adresinizi doğru giriniz.")
    private String email;

    @Column(length = 6 , nullable = false)
    private String password;

    @Column(unique = true , length = 100 , nullable = false)
    @Pattern(regexp ="[1-9]{11}",message = "Lütfen başında 0 olmadan telefon numarınızı giriniz.")
    private String phoneNumber;

    @Type(type = "text")
    @Column(nullable = false)
    private String adress;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false ,updatable = false)
    private Date birthDate;
   
    @Column( nullable = false ,updatable = false)
    @CreationTimestamp
    private Date createDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date updateDate;

    @Enumerated(value = EnumType.STRING)
    @Column(length = 7, nullable = false)
    private StatusEnum memberStatus;


    private String memberRole;


//
//    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//    @JoinTable(
//            name = "users_roles",
//            joinColumns = @JoinColumn(
//                    name = "member_id", referencedColumnName = "id"),
//            inverseJoinColumns = @JoinColumn(
//                    name = "role_id", referencedColumnName = "id"))
//
//    private Collection< Role > roles;




}
