package com.example.module1.library;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private static BookRepository bookRepository = null;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getBooks() {

        return bookRepository.findAll();
    }

    public static void addNewBook(Book book) {
        Optional<Book> bookByTitle = bookRepository
                .findBookByTitle(book.getTitle());

        if (bookByTitle.isPresent()) {
            throw new IllegalStateException("Book already exists");

        }


        bookRepository.save(book);
    }

    public void deleteStudent(Long id){
        boolean exists = bookRepository.existsById(id);
        if (!exists) {
            throw new IllegalStateException("Book with id " + id + " does not exist");
        }
        bookRepository.deleteById(id);
    }

    @Transactional
    public void updateStudent(
            Long id,
            String title,
            String author){
        Book book = bookRepository.findById(id).
                orElseThrow(()-> new IllegalStateException
                        ("Book with id " + id + " does not exist"));

        if (title != null && title.length() > 0 && !book.getTitle().equals(title)) {
            book.setTitle(title);

        }
        if (author != null && author.length() > 0 && !book.getAuthor().equals(author)) {
            Optional<Book> bookOptional = bookRepository
                    .findBookByTitle(title);
            if (bookOptional.isPresent()) {
                throw new IllegalStateException("Author already exists");
            }
            book.setAuthor(author);
        }
    }

    public Book findBookById(Long id){
        return bookRepository.findBookById(id);
    }

}
