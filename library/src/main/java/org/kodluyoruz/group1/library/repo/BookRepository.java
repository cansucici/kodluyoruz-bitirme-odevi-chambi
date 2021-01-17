package org.kodluyoruz.group1.library.repo;

import org.kodluyoruz.group1.library.model.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public interface BookRepository extends JpaRepository<Book, Long> {

//    @Query()
//    List<Books> getOrderedBooks();

    @Query("select b from Book b where b.deleted=false and b.bookName like %:bookName%")
    List<Book> findBooksByBookName (String bookName); //seacrhBynmae service

    @Transactional
    @Modifying
    @Query("update Book b set b.deleted=true where b.id=:id")
    void updateBookStatus(Long id); //delted service

    @Query("select b from Book b where b.deleted=false")
    List<Book> findAllBooks(); //getAll service








}
