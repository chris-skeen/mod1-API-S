package com.example.module1.library;


import jakarta.persistence.*;

@Entity
@Table
public class Book {
    @Id
    @SequenceGenerator(
            name = "book_sequence",
            sequenceName = "book_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "book_sequence"
    )
    private Long id;
    private String title;
    private String author;
    private String publisher;
    private Integer YearPublished;

//    Gets with ID
    public Book(Long id,
                String title,
                String author,
                String publisher,
                Integer yearPublished) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.YearPublished = yearPublished;
    }

//    Gets without ID
    public Book(String title,
                String author,
                String publisher,
                Integer yearPublished) {
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.YearPublished = yearPublished;
    }

    public Book() {

    }

//    Getters / Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Integer getYearPublished() {
        return YearPublished;
    }

    public void setYearPublished(Integer yearPublished) {
        YearPublished = yearPublished;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", publisher='" + publisher + '\'' +
                ", YearPublished=" + YearPublished +
                '}';
    }
}
