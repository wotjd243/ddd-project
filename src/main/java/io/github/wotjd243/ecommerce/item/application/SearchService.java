package io.github.wotjd243.ecommerce.item.application;

import io.github.wotjd243.ecommerce.item.domain.search.*;
import io.github.wotjd243.ecommerce.item.infra.ItemRepository;
import io.github.wotjd243.ecommerce.product.domain.Item;

import java.util.Collections;
import java.util.List;

public class SearchService {
    private final ItemRepository itemRepository;

    public SearchService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public List<Item> searchItems(String keyword, int pageNumber, int pageSize,
                                SortParameter sortParameter, SortOrder sortOrder) {
        QueryKeyword queryKeyword = new QueryKeyword(keyword);
        Page page = new Page(pageNumber, pageSize);
        Sort sort = new Sort(sortParameter, sortOrder);

        List<Item> items = itemRepository.findByQueryKeyword(queryKeyword, page, sort);
        return Collections.unmodifiableList(items);
    }

    public List<Item> searchItems(int pageNumber, int pageSize, SortParameter sortParameter, SortOrder sortOrder) {
        Page page = new Page(pageNumber, pageSize);
        Sort sort = new Sort(sortParameter, sortOrder);

        List<Item> items = itemRepository.findAll(page, sort);
        return Collections.unmodifiableList(items);
    }
}
