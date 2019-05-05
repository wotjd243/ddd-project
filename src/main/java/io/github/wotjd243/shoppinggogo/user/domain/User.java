package io.github.wotjd243.shoppinggogo.user.domain;

public class User {

    private Long id;
    private Email email;
    private Address address;
    private Phone phoneNumber;
    private PassWord password;

    public User(Long id, Email email, Address address, Phone phoneNumber, PassWord password) {
        this.id = id;
        this.email = email;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.password = password;
    }



}
