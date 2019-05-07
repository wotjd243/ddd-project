package io.github.wotjd243.aladin.buyer.domain;

import io.github.wotjd243.aladin.common.domain.Address;
import io.github.wotjd243.aladin.common.domain.Email;
import io.github.wotjd243.aladin.common.domain.Name;
import io.github.wotjd243.aladin.common.domain.PhoneNumber;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.UUID;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Buyer {

    private Long id;

    private Name name;

    private PhoneNumber phoneNumber;

    private Email email;

    private Address address;

    public Buyer(String name, String phoneNumber, String email, String address) {
        this.id = UUID.randomUUID().getMostSignificantBits();
        this.name = new Name(name);
        this.phoneNumber = new PhoneNumber(phoneNumber);
        this.email = new Email(email);
        this.address = new Address(address);
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

    public String getAddress() {
        return address.getAddress();
    }
}
