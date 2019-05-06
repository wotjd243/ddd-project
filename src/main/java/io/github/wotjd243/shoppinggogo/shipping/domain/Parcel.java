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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }
}

