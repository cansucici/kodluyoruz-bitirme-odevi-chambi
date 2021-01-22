package org.kodluyoruz.group1.library.dao;

import org.kodluyoruz.group1.library.model.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

    List<Author> findAllByDeletedIsFalse();
    

    Author findAuthorByNameSurnameLikeAndDeletedIsFalse(String nameSurname);

    @Modifying
    @Transactional
    @Query("update Author a set a.deleted=true where a.id=:id")
    void deleteAuthor(Long id);



}
