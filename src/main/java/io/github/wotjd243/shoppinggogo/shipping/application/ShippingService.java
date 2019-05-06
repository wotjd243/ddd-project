package io.github.wotjd243.shoppinggogo.shipping.application;

import io.github.wotjd243.shoppinggogo.shipping.domain.Shipping;
import io.github.wotjd243.shoppinggogo.shipping.infra.ShippingRepository;
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

    public Optional<Shipping> getShippingInfo(final String shippingNum){
        return shippingRepository.findByShppingNum(shippingNum);
    }

}
