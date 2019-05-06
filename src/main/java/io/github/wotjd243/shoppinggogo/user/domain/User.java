package io.github.wotjd243.shoppinggogo.user.domain;

public class User {

    private String id;
    private Email email;
    private Address address;
    private Phone phoneNumber;

    public User(String id, String email, String address, String phoneNumber) {
        this.id = id;
        this.email = new Email(email);
        this.address = new Address(address);
        this.phoneNumber = new Phone(phoneNumber);
    }

    public void changeAddress(String newAddress){

        this.address= new Address(newAddress);
    }

}
