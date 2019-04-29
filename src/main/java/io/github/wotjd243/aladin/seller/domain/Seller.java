package io.github.wotjd243.aladin.seller.domain;

import io.github.wotjd243.aladin.common.Email;
import io.github.wotjd243.aladin.common.Name;
import io.github.wotjd243.aladin.common.PhoneNumber;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.UUID;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Seller {

    private Long id;

    private Name name;

    private PhoneNumber phoneNumber;

    private Email email;

    public Seller(String name, String phoneNumber, String email) {
        this.id = UUID.randomUUID().getMostSignificantBits();
        this.name = new Name(name);
        this.phoneNumber = new PhoneNumber(phoneNumber);
        this.email = new Email(email);
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
}
