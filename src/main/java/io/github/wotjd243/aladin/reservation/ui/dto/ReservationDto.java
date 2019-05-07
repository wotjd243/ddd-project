package io.github.wotjd243.aladin.reservation.ui.dto;

import io.github.wotjd243.aladin.utils.LongConvert;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

public class ReservationDto {

    @Setter
    @Getter
    @NoArgsConstructor
    public static class Create {

        @NotBlank
        private String bookId;

        @Setter(AccessLevel.NONE)
        private Long registeredBookId;

        public void validAndConvert() {

            this.registeredBookId = LongConvert.valueOf("bookId", bookId);
        }
    }
}
