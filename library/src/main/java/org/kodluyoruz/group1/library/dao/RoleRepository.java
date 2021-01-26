package org.kodluyoruz.group1.library.dao;

import org.kodluyoruz.group1.library.model.entities.Member;
import org.kodluyoruz.group1.library.model.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {

   Role findByRoleName(String roleName);
}
