package io.github.wotjd243.shoppinggogo.shipping.domain;

// ( 송장번호, 택배사, 대표번호 )
public class Invoice {

    // ex)349827715741
    private String number;
    // ex)택배사
    private Parcel parcel;
    // 대표번호
    private String phoneNum;

    public Invoice(String number, Parcel parcel, String phoneNum) {
        this.number = number;
        this.parcel = parcel;
        this.phoneNum = phoneNum;
    }
}
