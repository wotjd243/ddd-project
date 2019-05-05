package io.github.wotjd243.shoppinggogo.user.domain;

import io.github.wotjd243.shoppinggogo.shipping.domain.GeneralBusinessNumber;
import io.github.wotjd243.shoppinggogo.shipping.domain.GeneralEmail;
import io.github.wotjd243.shoppinggogo.shipping.domain.GeneralPhoneNumber;

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

    public static class Seller {

        private String id;
        private String brandName;
        private String president;
        private GeneralPhoneNumber phoneNum;
        private GeneralEmail email;
        private GeneralBusinessNumber businessNum;
        private String addresss;


        public Seller(String id, String brandName, String president, GeneralPhoneNumber phoneNum, GeneralEmail email, GeneralBusinessNumber businessNum, String addresss) {
            this.id = id;
            this.brandName = brandName;
            this.president = president;
            this.phoneNum = phoneNum;
            this.email = email;
            this.businessNum = businessNum;
            this.addresss = addresss;
        }

    }
}
