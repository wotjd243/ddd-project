package io.github.wotjd243.shoppinggogo.user.domain;

import lombok.Getter;

@Getter
public class User {

    private Long id;
    private Email email;
    private Address address;
    private Phone phoneNumber;

    public User(Long id, String email, String address, String phoneNumber) {
        this.id = id;
        this.email = new Email(email);
        this.address = new Address(address);
        this.phoneNumber = new Phone(phoneNumber);
    }

    public void changeAddress(String newAddress){

        this.address= new Address(newAddress);
    }

    public Address getAddress() {
        return address;
    }

    public Phone getPhoneNumber() {
        return phoneNumber;
    }
}
