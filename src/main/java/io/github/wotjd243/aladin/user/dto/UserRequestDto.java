package io.github.wotjd243.aladin.user.dto;

import io.github.wotjd243.aladin.user.domain.User;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class UserRequestDto {

    private String loginId;

    private String password;

    private String name;

    private String phoneNumber;

    private String email;

    private String address;

    private boolean isSeller;

    public User toEntity() {
        return User.of(loginId, password, name, phoneNumber, email, address, isSeller);
    }

    public String getLoginId() {
        return loginId;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public boolean isSeller() {
        return isSeller;
    }
}
