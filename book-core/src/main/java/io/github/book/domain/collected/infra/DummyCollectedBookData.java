package io.github.book.domain.collected.infra;

import io.github.book.domain.collected.domain.BookLocation;
import io.github.book.domain.collected.domain.CollectedBook;

import java.util.HashMap;
import java.util.Map;

public class DummyCollectedBookData {
    private static final Map<Long, CollectedBook> data = new HashMap<>();

    static {
        String bookshelfLocation = "bookshelfLocation";
        put(1L, "978-89-97924-24-0", "storeLocation", bookshelfLocation);
        put(1L, "978-89-97924-41-7", "storeLocation", bookshelfLocation);
        put(1L, "979-11-6050-681-5", "storeLocation", bookshelfLocation);
        put(1L, "978-89-6626-404-9", "storeLocation", bookshelfLocation);
        put(1L, "978-89-6629-092-8", "storeLocation", bookshelfLocation);
        put(1L, "978-89-9813-976-6", "storeLocation", bookshelfLocation);
        put(1L, "978-89-6055-283-7", "storeLocation", bookshelfLocation);
        put(1L, "978-89-97924-41-7", "storeLocation", bookshelfLocation);
        put(1L, "89-329-0469-3", "storeLocation", bookshelfLocation);
        put(1L, "978-11-334-7996-2", "storeLocation", bookshelfLocation);
        put(1L, "978-89-546-3726-8", "storeLocation", bookshelfLocation);
        put(1L, "978-89-6077-103-1", "storeLocation", bookshelfLocation);
    }

    public static CollectedBook get(Long id) {
        return data.get(id);
    }

    private static CollectedBook put(Long id, String isbn, String storeLocation, String bookshelfLocation) {
        BookLocation bookLocation = new BookLocation(storeLocation, bookshelfLocation);
        return data.put(id, new CollectedBook(isbn, bookLocation));
    }

}
