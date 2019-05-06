package io.github.wotjd243.shoppinggogo.shipping.infra;

import io.github.wotjd243.shoppinggogo.shipping.domain.*;
import io.github.wotjd243.shoppinggogo.utils.ShippingStatus;
import io.github.wotjd243.shoppinggogo.user.domain.Seller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class DummyShippingData {
    private static final Map<String,Shipping> data = new HashMap<>();

    static {
        put("1", "123-1111-1111", "Aladin", ShippingStatus.SHIPPING_DONE.getValue(), "111-2323-4444", "분당점",
                new Date(), new Invoice("349827715741", new Parcel("1","대한통운","001-222-2222"),"000-333-1111"),
                new Seller("1", "개밥왕", "양지한", GeneralPhoneNumber.valueOf("010-7795-1820"),
                        GeneralEmail.valueOf("yangjeehan@naver.com"), GeneralBusinessNumber.valueOf("111-22-3333"), "서현점"));
    }

    private static Shipping put(final String id, final String shippingNum, final String mall, final String shippingStatus, String orderId, String position,
                                Date processedData, Invoice invoice, Seller seller) {
        return data.put(shippingNum, new Shipping(id, shippingNum, mall, shippingStatus, orderId, position, processedData, invoice, seller));
    }


    public static Shipping get(final String shippingNum) {
        return data.get(shippingNum);
    }
}
