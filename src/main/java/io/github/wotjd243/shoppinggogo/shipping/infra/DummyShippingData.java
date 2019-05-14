package io.github.wotjd243.shoppinggogo.shipping.infra;

import io.github.wotjd243.shoppinggogo.shipping.domain.*;
import io.github.wotjd243.shoppinggogo.utils.ShippingStatus;
import io.github.wotjd243.shoppinggogo.seller.domain.Seller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class DummyShippingData {
    private static final Map<Long, Shipping> data = new HashMap<>();

    static {
        put(1l, ShippingStatus.SHIPPING_DONE.getValue(), 1l, "분당점",
                new Date(), new Invoice("349827715741", new Parcel("1", "대한통운", "001-222-2222"), "000-333-1111"),
                new Seller(1l, "개밥왕", "양지한", GeneralPhoneNumber.valueOf("010-7795-1820"),
                        GeneralEmail.valueOf("yangjeehan@naver.com"), GeneralBusinessNumber.valueOf("111-22-3333"), "서현점"));
    }

    private static Shipping put(final Long id, final String shippingStatus, Long orderId, String position,
                                Date processedData, Invoice invoice, Seller seller) {
        return data.put(id, new Shipping(id, shippingStatus, orderId, position, processedData, invoice, seller));
    }

    public static Shipping get(final Long shippingId) {
        return data.get(shippingId);
    }

    public static boolean save(final Shipping shipping) {
        data.put(shipping.getId(), shipping);
        return (data.get(shipping.getId()) != null);
    }

    public static boolean update(final Shipping shipping) {
        data.put(shipping.getId(), shipping);
        return (data.get(shipping.getId()) != null);
    }

}
