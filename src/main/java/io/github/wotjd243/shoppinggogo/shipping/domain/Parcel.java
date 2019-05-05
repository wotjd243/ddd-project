package io.github.wotjd243.shoppinggogo.shipping.domain;

// 택배사
public class Parcel {

    private String id;
    private String name;
    private String phoneNum;

    public Parcel(String id, String name, String phoneNum) {
        this.id = id;
        this.name = name;
        this.phoneNum = phoneNum;
    }
}

