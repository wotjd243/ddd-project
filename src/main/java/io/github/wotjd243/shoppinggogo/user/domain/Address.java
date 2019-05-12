package io.github.wotjd243.shoppinggogo.user.domain;

import lombok.Getter;

@Getter
public class Address {
    private String address;

    public Address(String address) {
        this.address = address;
    }

}
