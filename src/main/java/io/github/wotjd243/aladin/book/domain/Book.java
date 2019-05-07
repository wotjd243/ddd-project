package io.github.wotjd243.aladin.book.domain;

import io.github.wotjd243.aladin.common.Name;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.UUID;

@NoArgsConstructor
public class Book {

    private Long id;

    private Name name;

    private Author author;

    private Category category;

    private Publisher publisher;

    public Book(String name, String author, String category, String publisher) {
        this.id = UUID.randomUUID().getMostSignificantBits();
        this.name = new Name(name);
        this.author = new Author(author);
        this.category = new Category(category);
        this.publisher = new Publisher(publisher);
    }
}
