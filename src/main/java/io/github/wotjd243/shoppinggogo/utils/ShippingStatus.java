package io.github.wotjd243.shoppinggogo.utils;

import io.github.wotjd243.shoppinggogo.utils.EnumModel;

public enum ShippingStatus implements EnumModel{

    SHIPPING_READY("배송준비중"),
    SHIPPING_PICKUP("집하"),
    SHIPPING_DOING("배송중"),
    SHIPPING_DONE("배달완료");

    private String value;

    ShippingStatus(String value) {
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
