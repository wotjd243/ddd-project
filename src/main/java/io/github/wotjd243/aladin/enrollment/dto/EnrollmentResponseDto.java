package io.github.wotjd243.aladin.enrollment.dto;

import io.github.wotjd243.aladin.enrollment.domain.Enrollment;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class EnrollmentResponseDto {

    private Long id;

    private Long sellerId;

    private Long bookId;

    private Long count;

    private Long amount;

    public EnrollmentResponseDto(Enrollment enrollment) {
        this.id = enrollment.getId();
        this.sellerId = enrollment.getSellerId();
        this.bookId = enrollment.getSellerId();
        this.count = (long) enrollment.getRegisteredBooks().size();
        this.amount = enrollment.getAmount().getAmount();
    }
}
