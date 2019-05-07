package io.github.wotjd243.shoppinggogo.shipping.application;

import io.github.wotjd243.shoppinggogo.shipping.domain.*;
import io.github.wotjd243.shoppinggogo.shipping.infra.ShippingRepositoryImpl;
import io.github.wotjd243.shoppinggogo.seller.domain.Seller;
import io.github.wotjd243.shoppinggogo.utils.ShippingStatus;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Date;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

@RunWith(MockitoJUnitRunner.class)
public class ShippingServiceTest {

    @Mock
    private ShippingRepositoryImpl shippingRepository;

    @InjectMocks
    private ShippingService shippingService;

    @Test
    public void name() {
        given(shippingRepository.findByShppingId(any()))
                .willReturn(
                        Optional.of(//String id, String shppingNum, String mall, String shippingStatus, String orderId, String position, Date processedDate, Invoice invoice, Seller seller
                                new Shipping(1l,"123-1111-1111", "Aladin", ShippingStatus.SHIPPING_DONE.getValue(),
                                        new Date(), new Invoice("349827715741", new Parcel("1","대한통운","001-222-2222"),"000-333-1111"),
                                        new Seller(1l, "개밥왕", "양지한", GeneralPhoneNumber.valueOf("010-7795-1820"),
                                                GeneralEmail.valueOf("yangjeehan@naver.com"), GeneralBusinessNumber.valueOf("111-22-3333"), "서현점"))
                        )
                );

//        final boolean shippingService.
        final Shipping result = shippingService.getShippingInfo("123-1111-1111").get();

        assertThat(result).isNotNull();

    }

}