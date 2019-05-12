package io.github.wotjd243.shoppinggogo.shipping.application;

import io.github.wotjd243.shoppinggogo.shipping.domain.Shipping;
import io.github.wotjd243.shoppinggogo.shipping.domain.ShippingDetailInfo;
import io.github.wotjd243.shoppinggogo.shipping.domain.ShippingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ShippingService {

    @Autowired
    private ShippingRepository shippingRepository;

    public ShippingService(final ShippingRepository shippingRepository) {
        this.shippingRepository = shippingRepository;
    }

    public Optional<Shipping> getShippingInfo(final Long id){
        return shippingRepository.findByShppingId(id);
    }

    public boolean changeShippingStatus(final Long id, final String shippingStatus) {
        return shippingRepository.findByShppingId(id).map(shipping -> {
                ShippingDetailInfo shippingDetailInfo = shipping.getShippingDetail();
                shippingDetailInfo.setShippingStatus(shippingStatus);
                return shippingRepository.updateShipping(shipping);
            }).orElse(false);
    }

    public boolean changeShippingPosition(final Long id, final String position) {
        return shippingRepository.findByShppingId(id).map(shipping -> {
            ShippingDetailInfo shippingDetailInfo = shipping.getShippingDetail();
            shippingDetailInfo.setPosition(position);
            return shippingRepository.updateShipping(shipping);
        }).orElse(false);
    }



}
