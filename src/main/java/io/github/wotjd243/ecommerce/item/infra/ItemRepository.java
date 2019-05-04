package io.github.wotjd243.ecommerce.item.infra;

import io.github.wotjd243.ecommerce.item.domain.search.Page;
import io.github.wotjd243.ecommerce.item.domain.search.QueryKeyword;
import io.github.wotjd243.ecommerce.item.domain.search.Sort;
import io.github.wotjd243.ecommerce.product.domain.Item;

import java.util.List;

public interface ItemRepository {
    List<Item> findAll(Page page, Sort sort);

    List<Item> findByQueryKeyword(QueryKeyword queryKeyword, Page page, Sort sort);
}
