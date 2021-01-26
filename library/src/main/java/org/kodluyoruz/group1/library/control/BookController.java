package org.kodluyoruz.group1.library.control;

import lombok.RequiredArgsConstructor;
import org.kodluyoruz.group1.library.dto.BookDTO;
import org.kodluyoruz.group1.library.model.entities.Book;
import org.kodluyoruz.group1.library.service.IBookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collection;

@Controller
@RequiredArgsConstructor
public class BookController {

    private final IBookService bookService;

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

        return "redirect:/booklist";
    }

    @GetMapping("/update/{id}")
    public String getUpdateBook(@PathVariable Long id, Model model) {
        BookDTO bookDTO = (bookService.getBookById(id));
        model.addAttribute("bookDTO", bookDTO);
        return "update_book";
    }

    @PostMapping("/update/{id}")
    public String postUpdateBook(@PathVariable Long id, BookDTO bookDTO) {
        bookService.update(id, bookDTO);
        return "redirect:/booklist";
    }

    @PostMapping("/delete/{id}")
    public String deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
        return "redirect:/booklist";
    }

    @GetMapping("/books/{bookName}")
    public Collection<Book> showSearchResult(@PathVariable String bookName) {
        return bookService.getBooksByBookName(bookName);
    }
}

