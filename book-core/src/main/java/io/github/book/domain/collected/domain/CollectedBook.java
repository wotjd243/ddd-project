package io.github.book.domain.collected.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Table(name = "collected_book")
public class CollectedBook {
    @Id
    @GeneratedValue
    private Long collected_book_id;

    @Column(name = "book_isbn", nullable = false, unique = true)
    private Long bookIsbn;

    @Column(nullable = false, columnDefinition = "bit default 0")
    private boolean isRent;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "storeLocation",
                    column = @Column(name = "collected_book_store_location")),
            @AttributeOverride(name = "bookshelfLocation",
                    column = @Column(name = "collected_book_bookshelf_location"))
    })
    private BookLocation bookLocation;

    public void rent() {
        this.isRent = true;
    }

    public void returned() {
        this.isRent = false;
    }

    @Builder
    public CollectedBook(Long bookIsbn, boolean isRent, BookLocation bookLocation) {
        this.bookIsbn = bookIsbn;
        this.isRent = isRent;
        this.bookLocation = bookLocation;
    }
}
