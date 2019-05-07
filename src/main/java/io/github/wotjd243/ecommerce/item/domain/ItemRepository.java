package io.github.wotjd243.ecommerce.item.domain;

import io.github.wotjd243.ecommerce.item.application.dto.PagingDto;
import io.github.wotjd243.ecommerce.item.domain.search.QueryKeyword;

import java.util.List;

public interface ItemRepository {
    Item findById(Long itemId);

    List<Item> findByUserId(String userId);

    List<Item> findAll();

    List<Item> findAll(PagingDto paging);

    List<Item> findByQueryKeyword(QueryKeyword queryKeyword, PagingDto paging);

    Item save(Item item);
}
