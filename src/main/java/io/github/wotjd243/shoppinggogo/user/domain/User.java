package io.github.wotjd243.shoppinggogo.user.domain;

public class User {
    private Long id;
    private Email email;
    private Address address;
    private Phone phoneNumber;
    private int point;

    public User(Long id, String email, String address, String phoneNumber, int point) {
        this.id = id;
        this.email = new Email(email);
        this.address = new Address(address);
        this.phoneNumber = new Phone(phoneNumber);
        this.point = point;
    }

    public void changeAddress(String newAddress){

        this.address= new Address(newAddress);
    }

    public Long getId() {
        return id;
    }

    public Address getAddress() {
        return address;
    }

    public Phone getPhoneNumber() {
        return phoneNumber;
    }

    public int getPoint() {
        return point;
    }

    public void changePoint(int point) {
        this.point = point;
    }
}

