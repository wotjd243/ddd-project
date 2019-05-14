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
                        //Long id, String shippingStatus, Long orderId, String position, Date processedDate, Invoice invoice, Seller seller
                        Optional.of(
                                new Shipping(1l, ShippingStatus.SHIPPING_DONE.getValue(), 1l, "Aladin", new Date(),
                                        new Invoice("349827715741", new Parcel("1", "대한통운", "001-222-2222"), "000-333-1111"),
                                        new Seller(1l, "개밥왕", "양지한", GeneralPhoneNumber.valueOf("010-7795-1820"),
                                                GeneralEmail.valueOf("yangjeehan@naver.com"), GeneralBusinessNumber.valueOf("111-22-3333"), "서현점"))
                        )
                );

        final Shipping result = shippingService.getShippingInfo(1l).get();

        assertThat(result).isNotNull();
    }

    /**
     * @// TODO: 14/05/2019 추후, 해결
     */
    @Test
    public void 배송상태변경() {
//        shippingService.changeShippingStatus(1l, ShippingStatus.SHIPPING_PICKUP.getValue());
//
//        Shipping shipping = shippingService.getShippingInfo(1l).orElseThrow(IllegalArgumentException::new);
//
//        assertThat(shipping.getShippingDetail().getShippingStatus()).isEqualTo(ShippingStatus.SHIPPING_PICKUP.getValue());
    }

}