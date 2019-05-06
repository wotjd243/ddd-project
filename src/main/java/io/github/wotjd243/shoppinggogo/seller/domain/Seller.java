package io.github.wotjd243.shoppinggogo.seller.domain;

public class Seller {

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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getPresident() {
        return president;
    }

    public void setPresident(String president) {
        this.president = president;
    }

    public GeneralPhoneNumber getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(GeneralPhoneNumber phoneNum) {
        this.phoneNum = phoneNum;
    }

    public GeneralEmail getEmail() {
        return email;
    }

    public void setEmail(GeneralEmail email) {
        this.email = email;
    }

    public GeneralBusinessNumber getBusinessNum() {
        return businessNum;
    }

    public void setBusinessNum(GeneralBusinessNumber businessNum) {
        this.businessNum = businessNum;
    }

    public String getAddresss() {
        return addresss;
    }

    public void setAddresss(String addresss) {
        this.addresss = addresss;
    }
}
