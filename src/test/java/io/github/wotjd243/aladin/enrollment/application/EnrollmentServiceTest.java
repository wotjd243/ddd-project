package io.github.wotjd243.aladin.enrollment.application;

import io.github.wotjd243.aladin.book.domain.Book;
import io.github.wotjd243.aladin.book.domain.BookRepository;
import io.github.wotjd243.aladin.enrollment.domain.Enrollment;
import io.github.wotjd243.aladin.enrollment.domain.EnrollmentRepository;
import io.github.wotjd243.aladin.enrollment.dto.EnrollmentRequestDto;
import io.github.wotjd243.aladin.enrollment.dto.EnrollmentResponseDto;
import io.github.wotjd243.aladin.exception.NotFoundException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doNothing;

@RunWith(MockitoJUnitRunner.class)
public class EnrollmentServiceTest {

    @Mock
    private EnrollmentRepository enrollmentRepository;

    @Mock
    private BookRepository bookRepository;


    @InjectMocks
    private EnrollmentService enrollmentService;


    @Test
    public void testSave() {
        //given
        given(bookRepository.findById(any()))
                .willReturn(Optional.of(new Book()));
        doNothing().when(enrollmentRepository).save(isA(Enrollment.class));

        EnrollmentRequestDto requestDto = new EnrollmentRequestDto(1L, 1L, 10L, 1000L);
        //when
        EnrollmentResponseDto responseDto = enrollmentService.save(requestDto);
        //then
        assertEnrollment(responseDto, 1L, 1L, 10L, 1000L);
    }


    @Test
    public void testFindById() {
        //given
        given(enrollmentRepository.findById(any()))
                .willReturn(Optional.of(Enrollment.of(1L, 1L, 10L, 1000L)));
        //when
        EnrollmentResponseDto responseDto = enrollmentService.findById(1L);
        //then
        assertEnrollment(responseDto, 1L, 1L, 10L, 1000L);
    }

    @Test(expected = NotFoundException.class)
    public void 찾는_등록이_없을시_에러발생() {
        //given
        given(enrollmentRepository.findById(any()))
                .willThrow(NotFoundException.class);
        //when
        enrollmentService.findById(1L);
        //then
    }

    private void assertEnrollment(EnrollmentResponseDto responseDto, Long sellerId, Long bookId, Long count, Long amount) {
        assertThat(responseDto.getId()).isNotNull();
        assertThat(responseDto.getAmount()).isEqualTo(amount);
        assertThat(responseDto.getCount()).isEqualTo(count);
        assertThat(responseDto.getBookId()).isEqualTo(bookId);
        assertThat(responseDto.getSellerId()).isEqualTo(sellerId);
    }
}