package io.github.wotjd243.ecommerce.order.application;

import io.github.wotjd243.ecommerce.order.infra.ItemRepository;

public class OrderService {

    private final ItemRepository itemRepository;

    public OrderService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }


}
