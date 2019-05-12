package io.github.wotjd243.shoppinggogo.seller.application;

import io.github.wotjd243.shoppinggogo.seller.domain.Seller;
import io.github.wotjd243.shoppinggogo.seller.domain.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SellerService {

    @Autowired
    private SellerRepository sellerRepository;

    public SellerService(final SellerRepository sellerRepository) {
        this.sellerRepository = sellerRepository;
    }

    public Optional<Seller> getSeller(final Long sellerId) {
        return this.sellerRepository.findBySellerId(sellerId);
    }

}
