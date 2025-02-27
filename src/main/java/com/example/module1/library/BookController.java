package com.example.module1.library;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="api/v1/book")
public class BookController {

    private final BookService bookService;
    private final BookRepository bookRepository;

    @Autowired
    public BookController(BookService bookService, BookRepository bookRepository) {
        this.bookService = bookService;
        this.bookRepository = bookRepository;
    }

    @GetMapping
    public List<Book> getBooks() {
        return bookService.getBooks();
    }

    @PostMapping
    public void registerNewBook(@RequestBody Book book){
        BookService.addNewBook(book);
    }
    @DeleteMapping(path="{id}")
    public void deleteBook(@PathVariable("id")Long id) {
        bookService.deleteStudent(id);
    }

    @PutMapping(path="{id}")
    public void updateBook(
            @PathVariable("id")Long id,
            @RequestParam(required = false) String title,
            @RequestParam(required = false) String author){
        bookService.updateStudent(id, title, author);

    }

    @GetMapping(path="{id}")
    public Book getBook(@PathVariable Long id){
        return bookService.findBookById(id);
    }
}
