package io.github.wotjd243.ecommerce.product.application;

import io.github.wotjd243.ecommerce.product.domain.Item;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ItemServiceTest {
    ItemService service = new ItemService();

    @Test
    public void 키워드를_기준으로_검색한다() {
        String keywords = "DDD";
        List<Item> items = service.search(keywords);

        assertThat(items.get(0).isSamePrice(25.0)).isTrue();
    }
}