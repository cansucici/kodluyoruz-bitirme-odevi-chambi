package org.kodluyoruz.group1.library.control;

import lombok.RequiredArgsConstructor;
import org.kodluyoruz.group1.library.dto.BookDTO;
import org.kodluyoruz.group1.library.model.entities.Book;
import org.kodluyoruz.group1.library.service.BookService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequiredArgsConstructor
@RequestMapping("/books")
public class BookController {

    //endpointler düzenlendi.
    //method isimleri düzenlendi.

    private final BookService bookService;


    @GetMapping
    public Collection<Book> getBookList() {
        return bookService.getAllBooks();
    }


    @PostMapping
    public Book saveBook(@RequestBody @Validated BookDTO bookDTO) {
        return bookService.save(bookDTO);

    }

    @PutMapping
    public Book updateBook(@RequestBody  @Validated BookDTO bookDTO) {
        return bookService.update(bookDTO);

    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
    }


    @GetMapping("/{bookName}")
    public Collection<Book> showSearchResult(@PathVariable String bookName) {
        return bookService.getBooksByBookName(bookName);
    }


}
