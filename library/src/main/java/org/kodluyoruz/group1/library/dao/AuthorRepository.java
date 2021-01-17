package org.kodluyoruz.group1.library.dao;

import org.kodluyoruz.group1.library.model.entities.Authors;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.List;

public interface AuthorRepository extends JpaRepository<Authors, Long> {

    @Query("select a from Authors a where a.deleted=false")
    List<Authors> findAll();

    @Query("select a from Authors a where a.deleted=false and a.nameSurname=:name")
    Collection<Authors> findAllByNameSurname(String name);

    @Modifying
    @Transactional
    @Query("update Authors a set a.deleted=true where a.id=:id")
    void updateAuthorStatus(Long id);


}
