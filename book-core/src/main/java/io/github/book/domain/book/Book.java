package io.github.book.domain.book;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity

@Getter
@ToString
@NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue
    @Column(name = "book_id")
    private Long bookId;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false, unique = true)
    private String isbn;
    @Column(nullable = false)
    private String author;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private LocalDate publishedDate;
    @Column(nullable = false, columnDefinition = "bit default 0")
    private boolean isRent;

    @OneToMany(mappedBy = "book")
    private Set<BookRentHistory> bookRentHistories;

    public void rent() {
        this.isRent = true;
    }

    public void returned() {
        this.isRent = false;
    }

    @Builder
    public Book(String title, String isbn, String author, String description, LocalDate publishedDate) {
        this.title = title;
        this.isbn = isbn;
        this.author = author;
        this.description = description;
        this.publishedDate = publishedDate;
    }
}
