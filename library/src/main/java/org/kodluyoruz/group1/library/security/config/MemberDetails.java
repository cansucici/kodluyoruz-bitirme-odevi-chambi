package org.kodluyoruz.group1.library.security.config;

import org.kodluyoruz.group1.library.model.entities.Member;
import org.kodluyoruz.group1.library.model.enums.StatusEnum;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;
import java.util.stream.Collectors;

public class MemberDetails implements UserDetails {

    private final String firstName;
    private final String lastName;
    private final String userName;
    private final String email;
    private final String password;
    private final String phoneNumber;
    private final String adress;
    private final Date birthDate;
    private final Date createDate;
    private final Date updateDate;
    private final StatusEnum memberStatus;
    private final List<GrantedAuthority> authorities;

    public MemberDetails(Member member) {
        firstName = member.getFirstName();
        lastName = member.getLastName();
        userName = member.getUserName();
        email = member.getEmail();
        password = member.getPassword();
        phoneNumber = member.getPhoneNumber();
        adress = member.getAdress();
        birthDate = member.getBirthDate();
        createDate = member.getCreateDate();
        updateDate = member.getUpdateDate();
        memberStatus = member.getMemberStatus();
        authorities = Arrays.stream(member.getMemberRole().split(",")).map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());

    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        if (memberStatus == StatusEnum.ACTIVE) {
            return true;
        } else {
            return false;
        }
    }
}