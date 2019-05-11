package io.github.wotjd243.ecommerce.item.domain;

import io.github.wotjd243.ecommerce.item.domain.exception.HasNotPermissionException;
import io.github.wotjd243.ecommerce.item.domain.search.QueryKeyword;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class ItemTest {

    @Test
    public void 키워드_매치() {
        // given
        Item item = newItem("dummy_item", 2, ItemState.SELLING);

        // when
        boolean shouldBeTrue = item.isKeywordMatched(new QueryKeyword("dummy"));

        // then
        assertThat(shouldBeTrue).isTrue();
    }

    @Test
    public void 키워드_매치_매치_안될_경우() {
        // given
        Item item = newItem("dummy_item", 2, ItemState.SELLING);

        // when
        boolean shouldBeFalse = item.isKeywordMatched(new QueryKeyword("스프링"));

        // then
        assertThat(shouldBeFalse).isFalse();
    }

    @Test
    public void Item_sold() {
        // given
        Item item = newItem("dummy_item", 2, ItemState.SELLING);

        // when
        item.sold(1);

        // then
        assertThat(item.getStock()).isEqualTo(1);
        assertThat(item.isSelling()).isTrue();
    }

    @Test
    public void Item_sold_재고_없을_시_상태_변경() {
        // given
        Item item = newItem("dummy_item", 2, ItemState.SELLING);

        // when
        item.sold(2);

        // then
        assertThat(item.getStock()).isEqualTo(0);
        assertThat(item.getItemState()).isEqualByComparingTo(ItemState.SOLD_OUT);
    }

    @Test
    public void Item_sold_판매_중이_아닐_때_IllegalStateexception() {
        // given
        Item item = newItem("dummy_item", 2, ItemState.BEFORE_SELLING);

        // when
        // then
        assertThatIllegalStateException()
                .isThrownBy(() -> item.sold(2));
    }

    @Test
    public void 판매_시작() {
        // given
        String sellerId = "Dummy_seller";
        Item item = newItem("dummy_item", 2, ItemState.BEFORE_SELLING);

        // when
        item.startSelling(sellerId);

        // then
        assertThat(item.isSelling()).isTrue();
    }

    @Test
    public void 판매_시작_다른_seller일_경우_HasNotPermissionException() {
        // given
        String fakeSellerId = "Fake_seller";
        Item item = newItem("dummy_item", 2, ItemState.BEFORE_SELLING);

        // when
        // then
        assertThatExceptionOfType(HasNotPermissionException.class)
                .isThrownBy(() -> item.startSelling(fakeSellerId));
    }

    public static Item newItem(String title, int stock, ItemState itemState) {
        String url = "http://thumbs1.ebaystatic.com/m/m80hGwQEYVi2QUduAtjeVhw/140.jpg";
        ItemDetail itemDetail = new ItemDetail(title, 30.40, url);

        return new Item(1L, "Dummy_seller", new Stock(stock), itemDetail, itemState);
    }
}