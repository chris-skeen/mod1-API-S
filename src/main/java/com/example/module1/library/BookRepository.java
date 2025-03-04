package com.example.module1.library;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookRepository
        extends JpaRepository<Book, Long> {
//    SELECT * FROM book WHERE title = ?

//    @Query("SELECT s FROM Book s WHERE s.title = ?1")
    Optional<Book> findBookByTitle(String title);

    Book findBookById(Long id);

    Optional<Book> findBookByAuthor(String author);
}
