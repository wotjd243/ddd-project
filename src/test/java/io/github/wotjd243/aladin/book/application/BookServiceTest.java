package io.github.wotjd243.aladin.book.application;

import io.github.wotjd243.aladin.book.domain.Book;
import io.github.wotjd243.aladin.book.domain.BookRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

@RunWith(MockitoJUnitRunner.class)
public class BookServiceTest {

    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private BookService bookService;

    @Test
    public void 책이_있나요() {
        // given
        given(bookRepository.findById(any()))
                .willReturn(
                        Optional.of(
                                new Book("이펙티브 자바", "조슈아 블로크", "IT서적", "개앞맵시")
                        )
                )
        ;

        // when
        boolean isExist = bookService.isExist(1L);

        // then
        assertThat(isExist).isTrue();
    }
}
