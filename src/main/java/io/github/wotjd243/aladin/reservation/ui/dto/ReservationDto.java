package io.github.wotjd243.aladin.reservation.ui.dto;

import io.github.wotjd243.aladin.utils.LongConvert;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ReservationDto {

    @NoArgsConstructor
    public static class Create {

        @Setter(AccessLevel.PRIVATE)
        @NotBlank
        private String bookId;

        public Long getRegisteredBookId() {

            return LongConvert.valueOf("bookId", bookId);
        }
    }
}
