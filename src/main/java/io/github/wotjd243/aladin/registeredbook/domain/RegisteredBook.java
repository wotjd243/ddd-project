package io.github.wotjd243.aladin.registeredbook.domain;

import io.github.wotjd243.aladin.book.domain.Book;
import io.github.wotjd243.aladin.enrollment.domain.Enrollment;
import io.github.wotjd243.aladin.enrollment.domain.UnitAmount;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class RegisteredBook {

    private Long id;

    private Book book;

    private UnitAmount amount;

    private Enrollment enrollment;

    public RegisteredBook(Book book, UnitAmount amount) {
        this.id = UUID.randomUUID().getMostSignificantBits();
        this.book = book;
        this.amount = amount;
    }

    public void setEnrollment(Enrollment enrollment) {
        this.enrollment = enrollment;
    }

    public boolean equalsBook(RegisteredBook registeredBook) {

        return this.id.equals(registeredBook.id);
    }
}
