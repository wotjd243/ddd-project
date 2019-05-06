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
    private Long collectedBookId;

    @Column(name = "book_isbn", nullable = false)
    private String bookIsbn;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "storeLocation",
                    column = @Column(name = "collected_book_store_location")),
            @AttributeOverride(name = "bookshelfLocation",
                    column = @Column(name = "collected_book_bookshelf_location"))
    })
    private BookLocation bookLocation;

    @Column(name = "collected_book_rent_status")
    @Enumerated(EnumType.STRING)
    private BookRentStatus bookRentStatus = BookRentStatus.RENT_AVAILABLE;

    public void rent() {
        if (!this.bookRentStatus.isRent()) {
            throw new IllegalArgumentException("현재 대여중인 도서입니다.");
        }
        this.bookRentStatus = BookRentStatus.RENT_ALREADY;
    }

    public void returned() {
        if (this.bookRentStatus.isRent()) {
            throw new IllegalArgumentException("이미 반납이 완료된 도서입니다.");
        }
        this.bookRentStatus = BookRentStatus.RENT_AVAILABLE;
    }

    @Builder
    public CollectedBook(String bookIsbn, boolean isRent, BookLocation bookLocation) {
        this.bookIsbn = bookIsbn;
        this.bookLocation = bookLocation;
    }
}
