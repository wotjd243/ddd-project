package io.github.book.domain.user.domain;

import io.github.book.domain.collected.domain.CollectedBook;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PACKAGE)
public class User {
    @Id
    @GeneratedValue
    @Column(name = "user_id")
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Account account;

    @Column(nullable = false)
    private String phoneNumber;

    @Column(nullable = false)
    private LocalDate birthDay;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private Set<CollectedBook> collectedBooks;

    @Builder
    public User(String name, String email, String password, String phoneNumber, LocalDate birthDay) {
        this.name = name;
        this.account = new Account(email, password);
        this.phoneNumber = phoneNumber;
        this.birthDay = birthDay;
    }
}
