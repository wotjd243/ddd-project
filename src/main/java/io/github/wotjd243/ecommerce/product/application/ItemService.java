package io.github.wotjd243.ecommerce.product.application;

import io.github.wotjd243.ecommerce.product.domain.Item;
import io.github.wotjd243.support.ecommerce.product.ItemRepository;

import java.util.List;

public class ItemService {

    public List<Item> search(String keywords) {
        return ItemRepository.findByKeywords(keywords);
    }
}
