package io.github.wotjd243.ecommerce.order.application;

import io.github.wotjd243.ecommerce.order.application.dto.ShoppingBasketDto;
import io.github.wotjd243.ecommerce.order.domain.Buyer;
import io.github.wotjd243.ecommerce.order.domain.ConsideringItem;
import io.github.wotjd243.ecommerce.order.domain.ShoppingBasket;
import io.github.wotjd243.ecommerce.order.domain.ShoppingBasketRepository;

import java.util.List;

public class ShoppingBasketService {
    private ShoppingBasketRepository shoppingBasketRepository;
    private ShoppingBasketService shoppingBasketService;

    public ShoppingBasketService(ShoppingBasketRepository shoppingBasketRepository, ShoppingBasketService shoppingBasketService) {
        this.shoppingBasketRepository = shoppingBasketRepository;
        this.shoppingBasketService = shoppingBasketService;
    }

    public ShoppingBasket saveShoppingBasket(Buyer buyer, ShoppingBasketDto shoppingBasketDto) {
        ShoppingBasket shoppingBasket = new ShoppingBasket(buyer, shoppingBasketDto.getConsideringItems());
        return shoppingBasketRepository.save(shoppingBasket);
    }



}
