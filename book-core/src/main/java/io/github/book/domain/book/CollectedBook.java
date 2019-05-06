package io.github.book.domain.book;

import javax.persistence.*;

@Entity
public class CollectedBook {
    @Id
    @GeneratedValue
    private Long id;

    private int totalQuantity;

    private int nowQuantity;

    @OneToOne()
    @JoinColumn(name = "book_isbn")
    private Book book;
}
