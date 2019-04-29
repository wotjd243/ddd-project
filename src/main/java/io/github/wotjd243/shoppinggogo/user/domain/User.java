package io.github.wotjd243.shoppinggogo.user.domain;

public class User {

    private String id;
    private String email;
    private String address;
    private String phoneNumber;
    private String password;

    public User(String id, String email, String address, String phoneNumber, String password) {
        this.id = id;
        this.email = email;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.password = password;
    }

}
