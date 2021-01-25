package org.kodluyoruz.group1.library.service.impl;

import lombok.RequiredArgsConstructor;
import org.kodluyoruz.group1.library.converter.BookDTOToBooksConverter;
import org.kodluyoruz.group1.library.converter.BookToDTOConverter;
import org.kodluyoruz.group1.library.dao.BookRepository;
import org.kodluyoruz.group1.library.dto.BookDTO;
import org.kodluyoruz.group1.library.model.entities.Book;
import org.kodluyoruz.group1.library.service.BookService;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Collection;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {


    private final BookRepository bookRepository;

    private final BookDTOToBooksConverter bookDTOToBooksConverter;
    private final BookToDTOConverter bookToDTOConverter;


    @Override
    public Collection<Book> getAllBooks() {
        Collection<Book> books = bookRepository.findBooksByDeletedIsFalse();
        // if (CollectionUtils.isEmpty(books)) {
        //      throw new RuntimeException("Mevcutta henüz bir kitap bulunmamaktadır.");
        // }
        return books;
    }


    @Override
    public Book save(BookDTO dto) {
       /* String bookName = dto.getBookName();
        if (bookName.isEmpty()) {
            throw new RuntimeException("Kitap ismi boş bırakılamaz.");
        }*/

        boolean isExist = bookRepository.existsBooksByIsbn(dto.getIsbn());
        if (isExist) {
            throw new RuntimeException("Aynı barkod numarasına sahip kitap bulunmaktadır." +
                    " Barkod numaranızı tekrar kontrol ediniz!");
        }


        Book book = bookDTOToBooksConverter.convert(dto);
        return bookRepository.save(book);
    }

    @Override
    public Book update(Long id, BookDTO dto) {

        Book book = bookRepository.findById(id).orElse(null);

        book.setUpdateDate(new Date());
        book.setDeleted(dto.isDeleted());
        book.setPublisherName(dto.getPublisherName());
        book.setCategory(dto.getCategory());
        book.setLanguagesEnum(dto.getLanguagesEnum());
        book.setEditionNumber(dto.getEditionNumber());
        book.setPageNumber(dto.getPageNumber());
        book.setIsbn(dto.getIsbn());
        book.setBookName(dto.getBookName());
        book.setStatus(dto.getStatus());


        return bookRepository.save(book);
    }

    @Override
    public BookDTO getBookById(Long id) {
        Book b = bookRepository.findById(id).orElseThrow(() -> new NullPointerException("Aradığınız kitap bulunamadı."));
        return bookToDTOConverter.convert(b);
    }


    @Override
    public void deleteBook(Long id) {
        bookRepository.deleteBook(id);

    }

    @Override
    public List<Book> getBooksByBookName(String bookName) {

        Collection<Book> books = bookRepository.findByBookNameLikeAndDeletedIsFalse(bookName);
        if (CollectionUtils.isEmpty(books)) {
            throw new RuntimeException("Bu isimde kitap bulunmamaktadır.");
        } else {
            return bookRepository.findByBookNameLikeAndDeletedIsFalse(bookName);
        }
    }
}
