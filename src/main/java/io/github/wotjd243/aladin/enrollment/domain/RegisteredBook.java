package io.github.wotjd243.aladin.enrollment.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class RegisteredBook {

    private Long id;

    private Long bookId;


    public RegisteredBook(Long bookId) {
        this.id = UUID.randomUUID().getMostSignificantBits();
        this.bookId = bookId;
    }

    public boolean equalsBook(RegisteredBook registeredBook) {

        return this.id.equals(registeredBook.id);
    }
}
