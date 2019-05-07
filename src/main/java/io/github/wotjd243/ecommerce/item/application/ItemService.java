package io.github.wotjd243.ecommerce.item.application;

import io.github.wotjd243.ecommerce.item.application.dto.ItemRequestDto;
import io.github.wotjd243.ecommerce.item.application.dto.ItemResponseDto;
import io.github.wotjd243.ecommerce.item.application.dto.PagingDto;
import io.github.wotjd243.ecommerce.item.domain.*;
import io.github.wotjd243.ecommerce.item.domain.search.QueryKeyword;
import io.github.wotjd243.ecommerce.user.application.UserService;

import java.util.List;
import java.util.stream.Collectors;

public class ItemService {
    private final ItemRepository itemRepository;
    private final UserService userService;

    public ItemService(ItemRepository itemRepository, UserService userService) {
        this.itemRepository = itemRepository;
        this.userService = userService;
    }

    public List<ItemResponseDto> searchAll() {
        List<Item> items = itemRepository.findAll();
        return items.stream()
                .map(Item::toDto)
                .collect(Collectors.toList());
    }

    public List<ItemResponseDto> searchAll(PagingDto paging) {
        List<Item> items = itemRepository.findAll(paging);
        return items.stream()
                .map(Item::toDto)
                .collect(Collectors.toList());
    }

    public List<ItemResponseDto> searchItems(String keyword, PagingDto paging) {
        List<Item> items = itemRepository.findByQueryKeyword(new QueryKeyword(keyword), paging);
        return items.stream()
                .map(Item::toDto)
                .collect(Collectors.toList());
    }

    public ItemResponseDto register(Seller seller, ItemRequestDto itemDto, int stock) {
        userService.checkValid(seller.getUserId());

        ItemDetail detail = new ItemDetail(itemDto.getTitle(), itemDto.getPrice(), itemDto.getUrl());
        return itemRepository
                .save(new Item(seller.getUserId(), new Stock(stock), detail))
                .toDto();
    }

    public List<ItemResponseDto> findItemsOwned(Seller seller) {
        userService.checkValid(seller.getUserId());

        List<Item> items = itemRepository.findByUserId(seller.getUserId());
        return items.stream()
                .map(Item::toDto)
                .collect(Collectors.toList());
    }

    public ItemResponseDto findItem(long itemId) {
        return itemRepository.findById(itemId).toDto();
    }

    // TODO Sales service에서 관리
//    public ItemResponseDto startSelling(Seller seller, Long itemId) {
//        Item item = itemRepository.findById(itemId);
//        return item.startSelling(seller.getUserId()).toDto();
//    }
//
//    public ItemResponseDto sold(Long itemId, int numberOfSoldItems) {
//        Item item = itemRepository.findById(itemId);
//        return item.sold(numberOfSoldItems).toDto();
//    }
}
