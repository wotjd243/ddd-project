package io.github.wotjd243.shoppinggogo.seller.infra;

import io.github.wotjd243.shoppinggogo.seller.domain.Seller;
import io.github.wotjd243.shoppinggogo.shipping.domain.GeneralBusinessNumber;
import io.github.wotjd243.shoppinggogo.shipping.domain.GeneralEmail;
import io.github.wotjd243.shoppinggogo.shipping.domain.GeneralPhoneNumber;

import java.util.HashMap;
import java.util.Map;

public class DummySellerData {
    private static final Map<Long,Seller> sellers = new HashMap<Long, Seller>();

    static {
        put(1l, "개밥왕","양지한", GeneralPhoneNumber.valueOf("010-1111-2222"), GeneralEmail.valueOf("ddd01@daum.net"),
                GeneralBusinessNumber.valueOf("333-22-1111"),"경기도 성남시 분당구 탄천로 94");
    }

    public static Seller get(final Long id){
        return sellers.get(id);
    }

    private static Seller put(final Long id, final String brandName, final String president, final GeneralPhoneNumber phoneNumber, final GeneralEmail email,
                              final GeneralBusinessNumber businessNum, final String addresss){

        return sellers.put( id, new Seller( id, brandName, president, phoneNumber, email, businessNum, addresss));
    }

    public static boolean update(final Seller seller){

        Long sellerId = seller.getId();
        sellers.remove(sellerId);
        sellers.put( sellerId, seller);
        return sellers.get( sellerId ) != null;
    }


}
