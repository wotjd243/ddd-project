package io.github.wotjd243.ecommerce.order.domain;

import io.github.wotjd243.ecommerce.order.application.dto.OrderResponseDto;

import java.time.LocalDateTime;
import java.util.UUID;

public class Order {
    private String id;
    private LocalDateTime createdDate;
    private Buyer buyer;
    private PayMethod payMethod;
    private ShoppingBasket basket;

    public Order(Buyer buyer, PayMethod payMethod, ShoppingBasket basket) {
        this.id = UUID.randomUUID().toString();
        this.buyer = buyer;
        this.payMethod = payMethod;
        this.basket = basket;
    }

    public OrderResponseDto toDto() {
        return new OrderResponseDto(
                id,
                buyer.getUserId(),
                buyer.getAddress(),
                basket.getItemsName(),
                basket.sumPrice()
        );
    }

    public boolean isOwn(Buyer buyer) {
        return this.buyer == buyer;
    }

    public boolean match(String orderId) {
        return this.id == orderId;
    }

    public enum PayMethod {
        CARD,
        PHONE
    }
}
