package org.kodluyoruz.group1.library.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.kodluyoruz.group1.library.model.entities.Role;
import org.kodluyoruz.group1.library.model.enums.StatusEnum;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MemberDTO extends BaseDTO {

    private String firstName;

    private String lastName;

    private String userName;

    private String email;

    private String password;

    private String phoneNumber;

    private String adress;

    private Date birthOfDate;

    private StatusEnum memberStatus;

    private List<String> roles= new ArrayList<String>();

}
