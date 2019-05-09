package io.github.wotjd243.aladin.user.domain;

import io.github.wotjd243.aladin.common.domain.Address;
import io.github.wotjd243.aladin.common.domain.Email;
import io.github.wotjd243.aladin.common.domain.Name;
import io.github.wotjd243.aladin.common.domain.PhoneNumber;
import io.github.wotjd243.aladin.user.dto.UserRequestDto;
import io.github.wotjd243.aladin.user.dto.UserType;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.springframework.util.StringUtils;

import java.util.UUID;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {

    private Long id;

    private String loginId;

    private String password;

    private Name name;

    private PhoneNumber phoneNumber;

    private Email email;

    private Address address;

    private UserType userType;

    public static User createSeller(String loginId, String password, String name, String phoneNumber, String email) {
        return User.builder()
                .loginId(loginId)
                .password(password)
                .name(name)
                .phoneNumber(phoneNumber)
                .email(email)
                .userType(UserType.SELLER)
                .build();
    }

    public static User createBuyer(String loginId, String password, String name, String phoneNumber, String email, String address) {
        return User.builder()
                .loginId(loginId)
                .password(password)
                .name(name)
                .phoneNumber(phoneNumber)
                .email(email)
                .address(address)
                .userType(UserType.BUYER)
                .build();
    }

    public static User of(String loginId, String password, String name, String phoneNumber, String email, String address, boolean isSeller) {
        if (isSeller) {
            return createBuyer(loginId, password, name, phoneNumber, email, address);
        }

        return createSeller(loginId, password, name, phoneNumber, email);
    }

    @Builder
    public User(String loginId, String password, String name, String phoneNumber, String email, String address, UserType userType) {
        this.id = UUID.randomUUID().getMostSignificantBits();
        this.loginId = loginId;
        this.password = password;
        this.name = new Name(name);
        this.phoneNumber = new PhoneNumber(phoneNumber);
        this.email = new Email(email);
        this.userType = userType;
        this.address = StringUtils.isEmpty(address) ? null : new Address(address);
    }

    public String getName() {
        return name.getName();
    }

    public String getPhoneNumber() {
        return phoneNumber.getPhoneNumber();
    }

    public String getEmail() {
        return email.getEmail();
    }

    public Address getAddress() {
        return address;
    }

    public String getLoginId() {
        return loginId;
    }

    public String getPassword() {
        return password;
    }

    public UserType getUserType() {
        return userType;
    }
}
