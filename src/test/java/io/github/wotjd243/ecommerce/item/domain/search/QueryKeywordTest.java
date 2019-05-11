package io.github.wotjd243.ecommerce.item.domain.search;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class QueryKeywordTest {

    @Test
    public void 검색어는_3글자_이상() {
        // given
        String keyword = "xx";

        // when
        // then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new QueryKeyword(keyword));
    }

    @Test
    public void 검색어_매치_확인() {
        // given
        QueryKeyword queryKeyword = new QueryKeyword("다함께 DDD");

        // when
        boolean shouldBeTrue = queryKeyword.match("다함께");

        // then
        assertThat(shouldBeTrue).isTrue();
    }
}
