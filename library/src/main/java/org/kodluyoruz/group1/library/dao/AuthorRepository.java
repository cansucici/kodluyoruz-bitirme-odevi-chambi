package org.kodluyoruz.group1.library.dao;

import org.kodluyoruz.group1.library.model.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.List;

//
public interface AuthorRepository extends JpaRepository<Author, Long> {

    @Query("select a from Author a where a.deleted=false")
    List<Author> findAll();

    @Query("select a from Author a where a.deleted=false and a.nameSurname=:name")
    Collection<Author> findAllByNameSurname(String name);

    @Modifying
    @Transactional
    @Query("update Author a set a.deleted=true where a.id=:id")
    void updateAuthorStatus(Long id);


}
