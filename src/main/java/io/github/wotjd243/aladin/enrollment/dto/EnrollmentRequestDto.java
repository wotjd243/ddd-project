package io.github.wotjd243.aladin.enrollment.dto;

import io.github.wotjd243.aladin.enrollment.domain.Enrollment;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class EnrollmentRequestDto {

    private Long sellerId;

    private Long bookId;

    private Long count;

    private Long amount;

    public Enrollment toEntity() {
        return Enrollment.of(sellerId, bookId, count, amount);
    }
}
