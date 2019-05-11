package io.github.wotjd243.ecommerce.item.application;

import io.github.wotjd243.ecommerce.item.application.dto.ItemRequestDto;
import io.github.wotjd243.ecommerce.item.application.dto.ItemResponseDto;
import io.github.wotjd243.ecommerce.item.application.dto.PagingDto;
import io.github.wotjd243.ecommerce.item.domain.Seller;
import io.github.wotjd243.ecommerce.item.domain.search.SortOrder;
import io.github.wotjd243.ecommerce.item.domain.search.SortParameter;
import io.github.wotjd243.ecommerce.item.infra.DummyItemRepository;
import io.github.wotjd243.ecommerce.user.application.UserService;
import io.github.wotjd243.ecommerce.user.domain.exception.ResourceNotFoundException;
import io.github.wotjd243.ecommerce.user.infra.DummyUserRepository;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class ItemServiceTest {
    UserService userService = new UserService(new DummyUserRepository());
    ItemService itemService = new ItemService(new DummyItemRepository(), userService);
    Seller user = new Seller(DummyUserRepository.getTestUserId());

    @Test
    public void 물품_전체_검색() {
        List<ItemResponseDto> items = itemService.searchAll();
        assertThat(items.size()).isNotNull();
    }

    @Test
    public void 물품_소팅_검색() {
        // given
        PagingDto paging = new PagingDto(1, 10000, SortParameter.TITLE, SortOrder.ASCENDING);

        // when
        List<ItemResponseDto> items = itemService.searchAll(paging);

        // then
        List<String> titles = items.stream().map(ItemResponseDto::getTitle).collect(Collectors.toList());
        assertThat(titles).isSorted();
    }

    @Test
    public void 키워드를_기준으로_검색한다() {
        // given
        String title = "다함께 DDD";
        ItemResponseDto response = registItem(user, title, 700.0, 3);
        PagingDto paging = new PagingDto(1, 10000, SortParameter.TITLE, SortOrder.ASCENDING);

        // when
        List<ItemResponseDto> items = itemService.searchItems(title, paging);

        // then
        assertThat(items).contains(response);
    }

    @Test
    public void 물품을_등록한다() {
        int preSize = itemService.searchAll().size();

        String title = "다함께 DDD";
        ItemResponseDto response = registItem(user, title, 700.0, 3);

        assertThat(itemService.searchAll().size()).isEqualTo(preSize + 1);
        assertThat(response.getTitle()).isEqualTo(title);
    }

    @Test
    public void 자신이_등록한_물품을_확인() {
        // given
        String title = "다함께 DDD";
        ItemResponseDto response = registItem(user, title, 700.0, 3);

        // when
        List<ItemResponseDto> items = itemService.findItemsOwned(user);

        // then
        assertThat(items).contains(response);
    }

    @Test
    public void 유효하지_않은_사용자가_물품을_등록() {
        // given
        String title = "다른 테스트와 중복되지 않는 Test용 Title";
        Seller nonExistingUser = new Seller("TEST");

        // when
        // then
        assertThatExceptionOfType(ResourceNotFoundException.class)
                .isThrownBy(() -> registItem(nonExistingUser, title, 700.0, 3));

        List<ItemResponseDto> items = itemService.findItemsOwned(user);
        List<String> titles = items.stream().map(ItemResponseDto::getTitle).collect(Collectors.toList());
        assertThat(titles).doesNotContain(title);
    }

    private ItemResponseDto registItem(Seller seller, String title, double price, int stock) {
        ItemRequestDto request = new ItemRequestDto(title, price, "http://www.naver.com");
        return itemService.register(seller, request, stock);
    }
}