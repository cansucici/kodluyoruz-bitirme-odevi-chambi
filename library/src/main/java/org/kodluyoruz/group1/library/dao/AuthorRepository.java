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
<<<<<<< HEAD
    Author findAuthorByNameSurnameAndDeletedIsFalse(String nameSurname);
=======
    Collection<Author> findByNameSurnameWhereDeletedIsFalse(String nameSurname);

>>>>>>> 5e511ea (author's changed)
    @Modifying
    @Transactional
    @Query("update Author a set a.deleted=true where a.id=:id")
    void updateAuthorStatus(Long id);

  


}
