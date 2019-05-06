package io.github.wotjd243.ecommerce.item.application;

import io.github.wotjd243.ecommerce.item.application.dto.ItemRequestDto;
import io.github.wotjd243.ecommerce.item.application.dto.ItemResponseDto;
import io.github.wotjd243.ecommerce.item.domain.Item;
import io.github.wotjd243.ecommerce.item.domain.ItemDetail;
import io.github.wotjd243.ecommerce.item.domain.ItemRepository;
import io.github.wotjd243.ecommerce.item.domain.Seller;
import io.github.wotjd243.ecommerce.item.domain.exception.HasNotPermissionException;
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

    //TODO: 검색시 정렬, 페이징 등의 기능이 추가되어야 한다.

    public List<ItemResponseDto> searchAll() {
        List<Item> items = itemRepository.findAll();
        return items.stream().map(v -> v.toDto()).collect(Collectors.toList());
    }

    public List<ItemResponseDto> searchItems(String keyword) {
        List<Item> items = itemRepository.findByQueryKeyword(new QueryKeyword(keyword));
        return items.stream().map(v -> v.toDto()).collect(Collectors.toList());
    }

    public ItemResponseDto register(Seller seller, ItemRequestDto itemDto) {
        userService.checkValid(seller.getUserId());

        ItemDetail detail = new ItemDetail(itemDto.getTitle(), itemDto.getPrice(), itemDto.getUrl());
        return itemRepository.save(new Item(seller.getUserId(), detail)).toDto();
    }

    public ItemResponseDto activate(Seller seller, Long itemId) {
        Item item = itemRepository.findById(itemId);
        if(!item.checkOwner(seller.getUserId())) {
            throw new HasNotPermissionException("해당 물품에 대한 권한이 없습니다.");
        }

        item.activate();
        return item.toDto();
    }

    public List<String> findItemsOwned(Seller seller) {
        userService.checkValid(seller.getUserId());

        List<Item> items = itemRepository.findByUserId(seller.getUserId());
        return items.stream().map(v -> v.getTitle()).collect(Collectors.toList());
    }

    public ItemResponseDto findItem(long itemId) {
        return itemRepository.findById(itemId).toDto();
    }
}
