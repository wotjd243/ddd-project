package io.github.wotjd243.shoppinggogo.seller.domain;


import java.util.Optional;

public interface SellerRepository {
    Optional<Seller> findBySellerId(final Long sellerId);
    boolean updateSellerInfo(final Seller seller);

}