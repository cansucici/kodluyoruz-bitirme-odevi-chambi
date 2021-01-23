package org.kodluyoruz.group1.library.dao;

import org.kodluyoruz.group1.library.model.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public interface BookRepository extends JpaRepository<Book, Long> {
//TODO :  Bazı Query ler silindi, jpaRepositorynin sorguları yazıldı.

    List<Book> findByBookNameLikeAndDeletedIsFalse(String bookName);

    @Transactional
    @Modifying
    @Query("update Book b set b.deleted=true where b.id=:id")
    void deleteBook(Long id);     // uptadeBookStatus ---> deleteBook

    List<Book> findBooksByDeletedIsFalse();

    boolean existsBooksByIsbn(Long isbn);


    //    @Query()
//    List<Books> getOrderedBooks();


}
