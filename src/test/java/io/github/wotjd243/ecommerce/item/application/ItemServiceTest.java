package io.github.wotjd243.ecommerce.item.application;

import io.github.wotjd243.ecommerce.item.application.dto.ItemRequestDto;
import io.github.wotjd243.ecommerce.item.application.dto.ItemResponseDto;
import io.github.wotjd243.ecommerce.item.domain.Item.SellingState;
import io.github.wotjd243.ecommerce.item.domain.Seller;
import io.github.wotjd243.ecommerce.item.domain.search.QueryKeyword;
import io.github.wotjd243.ecommerce.item.infra.DummyItemRepository;
import io.github.wotjd243.ecommerce.user.application.UserService;
import io.github.wotjd243.ecommerce.user.domain.exception.ResourceNotFoundException;
import io.github.wotjd243.ecommerce.user.infra.DummyUserRepository;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ItemServiceTest {
    UserService userService = new UserService(new DummyUserRepository());
    ItemService itemService = new ItemService(new DummyItemRepository(), userService);
    Seller user = new Seller(DummyUserRepository.getTestUserId());

    @Test(expected = IllegalArgumentException.class)
    public void 키워드가_3글자_미만일_경우() {
        new QueryKeyword("DD");
    }

    @Test
    public void 물품_전체_검색() {
        List<ItemResponseDto> items = itemService.searchAll();
        assertThat(items.size()).isNotNull();
    }

    @Test
    public void 키워드를_기준으로_검색한다() {
        ItemRequestDto request = new ItemRequestDto("DDD란", 12.3, "http://www.naver.com");
        ItemResponseDto response = itemService.register(user, request);
        List<ItemResponseDto> items = itemService.searchItems("DDD");

        assertThat(items).contains(response);
    }

    @Test
    public void 물품을_등록한다() {
        int preSize = itemService.searchAll().size();
        ItemRequestDto request = new ItemRequestDto("DDD란", 12.3, "http://www.naver.com");
        ItemResponseDto response = itemService.register(user, request);

        assertThat(itemService.searchAll().size()).isEqualTo(preSize + 1);
        assertThat(request.getTitle()).isEqualTo(response.getTitle());
    }

    @Test
    public void 자신이_등록한_물품을_확인() {
        ItemRequestDto request = new ItemRequestDto("DDD란", 12.3, "http://www.naver.com");
        itemService.register(user, request);

        List<String> items = itemService.findItemsOwned(user);
        assertThat(items).contains(request.getTitle());
    }

    @Test(expected = ResourceNotFoundException.class)
    public void 유효하지_않은_사용자가_물품을_등록() {
        Seller user = new Seller("TEST");
        ItemRequestDto request = new ItemRequestDto("DDD란", 12.3, "http://www.naver.com");
        itemService.register(user, request);

        List<String> items = itemService.findItemsOwned(user);
        assertThat(items).contains(request.getTitle());
    }

    @Test
    public void 등록한_물품을_판매상태로_활성화() {
        ItemRequestDto request = new ItemRequestDto("DDD란", 12.3, "http://www.naver.com");
        itemService.register(user, request);

        ItemResponseDto response = itemService.findItem(1L);
        assertThat(response.getState()).isEqualTo(SellingState.CANCELED.getValue());

        response = itemService.activate(user, 1L);
        assertThat(response.getState()).isEqualTo(SellingState.ACTIVE.getValue());
    }
}