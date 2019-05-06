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
    @Column(nullable = false, unique = true)
    private Long isbn;

    @Column(nullable = false)
    private String title;

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

    @OneToOne(mappedBy = "book")
    private CollectedBook collectedBook;

    public void rent() {
        this.isRent = true;
    }

    public void returned() {
        this.isRent = false;
    }

    @Builder
    public Book(Long isbn, String title, String author, String description, LocalDate publishedDate) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.description = description;
        this.publishedDate = publishedDate;
    }
}
