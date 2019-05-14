package io.github.wotjd243.shoppinggogo.seller.infra;

import io.github.wotjd243.shoppinggogo.seller.domain.Seller;
import io.github.wotjd243.shoppinggogo.seller.domain.SellerRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class DummySellerRepository implements SellerRepository {

    @Override
    public Optional<Seller> findBySellerId(Long sellerId) {
        return Optional.ofNullable(DummySellerData.get(sellerId));
    }

    @Override
    public boolean updateSellerInfo(Seller seller) {

        return DummySellerData.update(seller);
    }
}
