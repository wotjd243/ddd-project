package io.github.book.domain.book.domain;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Table(name = "book",
        indexes = {
                @Index(columnList = "book_isbn", name = "IDX_BOOK_ISBN"),
                @Index(columnList = "book_title", name = "IDX_BOOK_TITLE")
        }
)
public class Book {
    @Id
    @Column(name = "book_isbn", nullable = false, unique = true)
    private Long isbn;

    @Column(name = "book_title", nullable = false)
    private String title;

    @Column(nullable = false)
    private String author;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private LocalDate publishedDate;

    @Builder
    public Book(Long isbn, String title, String author, String description, LocalDate publishedDate) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.description = description;
        this.publishedDate = publishedDate;
    }
}
