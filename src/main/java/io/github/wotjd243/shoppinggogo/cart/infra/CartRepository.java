package io.github.wotjd243.shoppinggogo.cart.infra;



import java.util.List;

public interface CartRepository {

    /**
     * Cart 에 담긴 제품 목록을 조회한다.
     * @param userId 유저 ID
     * @return Cart 에 담긴 제품 목록
     */
    public List<Long> selectProductsToCart(Long userId);


}
