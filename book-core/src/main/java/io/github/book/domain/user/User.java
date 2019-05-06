package io.github.book.domain.user;

import io.github.book.domain.book.BookRentHistory;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
public class User {
    @Id
    @GeneratedValue
    @Column(name = "user_id")
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String phoneNumber;

    @Column(nullable = false)
    private LocalDate birthDay;

    @OneToMany(mappedBy = "user")
    private Set<BookRentHistory> bookRentHistories;
}
