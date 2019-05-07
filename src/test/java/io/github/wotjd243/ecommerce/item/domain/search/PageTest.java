package io.github.wotjd243.ecommerce.item.domain.search;

import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class PageTest {

    @Test
    public void pageNumber는_1_이상() {
        // when
        // then
        assertThatIllegalArgumentException().isThrownBy(() -> new Page(0, 10));
    }

    @Test
    public void pageSize는_1_이상() {
        // when
        // then
        assertThatIllegalArgumentException().isThrownBy(() -> new Page(10, 0));
    }

    @Test
    public void 페이지_가져오기_범위_내() {
        // given
        List<Integer> ints = IntStream.rangeClosed(1, 23)
                .boxed()
                .collect(Collectors.toList());

        Page page = new Page(1, 10);

        // when
        List<Integer> intsOfPage = page.getPageElements(ints);

        // then
        assertThat(intsOfPage).containsSequence(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
    }

    @Test
    public void 해당_페이지의_요소_가져오기_범위_밖() {
        // given
        List<Integer> ints = IntStream.rangeClosed(1, 23)
                .boxed()
                .collect(Collectors.toList());

        Page page = new Page(100, 10);

        // when
        List<Integer> intsOfPage = page.getPageElements(ints);

        // then
        assertThat(intsOfPage).isEmpty();
    }

    @Test
    public void 페이지_사이즈만큼_해당되는_요소가_없을_때() {
        // given
        List<Integer> ints = IntStream.rangeClosed(1, 23)
                .boxed()
                .collect(Collectors.toList());

        Page page = new Page(3, 10);

        // when
        List<Integer> intsOfPage = page.getPageElements(ints);

        // then
        assertThat(intsOfPage).containsSequence(21, 22, 23);
    }
}
