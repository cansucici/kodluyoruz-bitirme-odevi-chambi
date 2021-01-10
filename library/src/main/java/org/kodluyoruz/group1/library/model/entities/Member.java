package org.kodluyoruz.group1.library.model.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;
import org.kodluyoruz.group1.library.model.enums.MemberStatusEnum;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "MEMBER")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "Fırst_Name",unique = false , length = 100 , nullable = false)
    private String firstName;

    @Column(name = "Last_Name",unique = false , length = 100 , nullable = false)
    private String lastName;

    @Column(name = "User_Name",unique = true , length = 100 , nullable = false)
    private String userName;

    @Column(name = "Email",unique = true , length = 100 , nullable = false)
    private String email;


    @Column(name = "Password",unique = false , length = 6 , nullable = false)
    private String password;

    @Column(name = "Phone_Number",unique = true , length = 100 , nullable = false)
    private Long phoneNumber;

    @Lob
    @Type(type = "text")
    @Column(name = "Adress",unique = false, nullable = false)
    private String adress;

    @Temporal(TemporalType.DATE)
    @Column(name = "Birth_Date", nullable = false ,updatable = false)
    private Date birthOfDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "Created_Date", nullable = false ,updatable = false)
    private Date createDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "Update_Date")
    private Date updateDate;

    @Enumerated(value = EnumType.STRING)
    @Column (name = "User_Status", length = 7, nullable = false)
    private MemberStatusEnum memberStatus;


    private String memberRole;



    /*@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(
                    name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "role_id", referencedColumnName = "id"))

    private Collection < Role > roles;*/




}
