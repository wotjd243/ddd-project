package io.github.wotjd243.ecommerce.order.application.dto;

import io.github.wotjd243.ecommerce.order.domain.Buyer;
import io.github.wotjd243.ecommerce.order.domain.ConsideringItem;
import io.github.wotjd243.ecommerce.order.domain.ShoppingBasket;

import java.time.LocalDateTime;
import java.util.List;

public class ShoppingBasketDto {

    private String basketId;
    private String buyerName;
    private List<ConsideringItem> consideringItems;

    public ShoppingBasketDto(String basketId, String buyerName, List<ConsideringItem> consideringItems) {
        this.basketId = basketId;
        this.buyerName = buyerName;
        this.consideringItems = consideringItems;
    }


    public String getBasketId() {
        return basketId;
    }

    public String getBuyerName() {
        return buyerName;
    }

    public List<ConsideringItem> getConsideringItems() {
        return consideringItems;
    }
}
