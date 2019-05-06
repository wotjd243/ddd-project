package io.github.book.domain.user.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.util.StringUtils;

import javax.persistence.Embeddable;

@Embeddable
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Getter
public class Account {
    private String email;

    private String password;

    @Builder
    public Account(String email, String password) {
        amendEmail(email);
        amendPassword(password);
    }

    private void amendEmail(String email) {
        if (StringUtils.isEmpty(email)) {
            throw new IllegalArgumentException("이메일은 필수 정보입니다.");
        }
        this.email = email;
    }

    private void amendPassword(String password) {
        if (StringUtils.isEmpty(password)) {
            throw new IllegalArgumentException("이메일은 필수 정보입니다.");
        }
        this.password = password;
    }

}
