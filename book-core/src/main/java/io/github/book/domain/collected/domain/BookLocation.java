package io.github.book.domain.collected.domain;

import javax.persistence.Embeddable;

@Embeddable
public class BookLocation {
    private String storeLocation;
    private String bookshelfLocation;
}
