package io.github.wotjd243.aladin.enrollment.application;

import io.github.wotjd243.aladin.book.domain.BookRepository;
import io.github.wotjd243.aladin.enrollment.domain.Enrollment;
import io.github.wotjd243.aladin.enrollment.domain.EnrollmentRepository;
import io.github.wotjd243.aladin.enrollment.dto.EnrollmentRequestDto;
import io.github.wotjd243.aladin.enrollment.dto.EnrollmentResponseDto;
import io.github.wotjd243.aladin.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EnrollmentService {

    private final EnrollmentRepository enrollmentRepository;

    private final BookRepository bookRepository;

    public EnrollmentResponseDto save(EnrollmentRequestDto enrollmentRequestDto) {
        validateExistOfBook(enrollmentRequestDto.getBookId());

        Enrollment enrollment = enrollmentRequestDto.toEntity();
        enrollmentRepository.save(enrollment);

        return new EnrollmentResponseDto(enrollment);
    }

    public EnrollmentResponseDto findById(Long id) {
        Enrollment enrollment = enrollmentRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("등록된 내역이 없습니다."));

        return new EnrollmentResponseDto(enrollment);
    }

    private void validateExistOfBook(Long id) {
        bookRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("책을 찾을 수 없습니다."));
    }
}
