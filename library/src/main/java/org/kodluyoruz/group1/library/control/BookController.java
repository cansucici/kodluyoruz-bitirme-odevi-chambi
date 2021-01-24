package org.kodluyoruz.group1.library.control;

import lombok.RequiredArgsConstructor;
import org.kodluyoruz.group1.library.dto.BookDTO;
import org.kodluyoruz.group1.library.model.entities.Book;
import org.kodluyoruz.group1.library.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Controller
@RequiredArgsConstructor
public class BookController {

    //endpointler düzenlendi.
    //method isimleri düzenlendi.

    private final BookService bookService;


    @GetMapping("/booklist")
    public String getBookList(Model model) {
        model.addAttribute("listbook", bookService.getAllBooks());
        return "book_list";
    }

    @GetMapping("/saveBook")
    public String getCreateBook(Model model) {
        model.addAttribute("dtoBook", new BookDTO());
        return "add_book";
    }

    @PostMapping("/saveBook")
    public String postCreateBook(@Validated BookDTO bookDTO) {
        bookService.save(bookDTO);
        return "redirect:/book_list";
    }

    @PutMapping("/showBookFormForUpdate/{id}")
    public String updateBook(@ModelAttribute @Validated BookDTO bookDTO) {
        bookService.update(bookDTO);
        return "redirect:/booklist";
    }

    @DeleteMapping("/delete/{id}")
    public void deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
    }


    @GetMapping("/books/{bookName}")
    public Collection<Book> showSearchResult(@PathVariable String bookName) {
        return bookService.getBooksByBookName(bookName);
    }


}
