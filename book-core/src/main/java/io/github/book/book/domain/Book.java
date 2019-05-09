package io.github.book.book.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

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
    private String isbn;

    @Column(name = "book_title", nullable = false)
    private String title;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "authorName",
                    column = @Column(name = "book_author_name")),
            @AttributeOverride(name = "authorAge",
                    column = @Column(name = "book_author_age"))
    })
    @Column(name = "book_author", nullable = false)
    private Author author;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private LocalDate publishedDate;

    @Builder
    public Book(String isbn, String title, Author author, String description, LocalDate publishedDate) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.description = description;
        this.publishedDate = publishedDate;
    }

    public boolean isContainsTitle(String title){
        return this.title.contains(title);
    }
}
