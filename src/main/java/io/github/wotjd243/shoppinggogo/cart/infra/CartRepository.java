package io.github.wotjd243.shoppinggogo.cart.infra;



import io.github.wotjd243.shoppinggogo.cart.domain.Cart;


public interface CartRepository {

    /**
     * 유저 ID에 의해, 카트를 찾는다.
     * @param userId 유저
     * @return Cart 정보
     */
    public Cart findCartByUserId(Long userId);

}
