package io.github.wotjd243.shoppinggogo.utils;

public enum PaymentType implements EnumModel{

    CARD("카드"),
    CASH("현금");

    private String value;

    PaymentType(String value) {
        this.value = value;
    }

    @Override
    public String getKey() {
        return name();
    }

    @Override
    public String getValue() {
        return value;
    }

}
