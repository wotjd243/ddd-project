package io.github.wotjd243.ecommerce.item.domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class StockTest {
    @Test
    public void 재고는_0개_이상() {
        // when
        // then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Stock(-1));
    }

    @Test
    public void 재고_줄이기() {
        // given
        Stock stock = new Stock(2);

        // when
        stock.decrease(2);

        // then
        assertThat(stock.getValue()).isEqualTo(0);
    }

    @Test
    public void 재고는_0개_이하로_줄어들_수_없다() {
        // given
        Stock stock = new Stock(0);

        // when
        // then
        assertThatIllegalStateException()
                .isThrownBy(() -> stock.decrease(1));
    }
}
