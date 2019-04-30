package io.github.book.domain.book;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class Book {
    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String Isbn;
    private String author;
    private String description;
    private LocalDate publishedDate;
    private boolean isRent;
}
