package org.kodluyoruz.group1.library.dao;

import org.kodluyoruz.group1.library.model.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {

    @Query(value = "SELECT * FROM book b WHERE b.book_name LIKE %:keyword% AND b.deleted=false", nativeQuery = true)
    List<Book> findBooksByKeyword(@Param("keyword") String keyword);

    @Transactional
    @Modifying
    @Query("update Book b set b.deleted=true where b.id=:id")
    void deleteBook(Long id);

    List<Book> findBooksByDeletedIsFalse();

    boolean existsBooksByIsbn(Long isbn);

}
