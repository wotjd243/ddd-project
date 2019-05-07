package io.github.wotjd243.aladin.reservation.ui;

import io.github.wotjd243.aladin.reservation.application.ReservationService;
import io.github.wotjd243.aladin.reservation.ui.dto.ReservationDto;
import io.github.wotjd243.aladin.response.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequestMapping("reservation")
@RestController
@RequiredArgsConstructor
public class ReservationController {

    private final ReservationService reservationService;

    /**
     * todo buyerId는 세션에서 가져옴
     *
     * @param create
     * @return
     */
    @PostMapping
    public ApiResponse add(@RequestBody @Valid ReservationDto.Create create) {

        create.validAndConvert();
        Long buyerId = 1L;
        reservationService.add(buyerId, create.getRegisteredBookId());

        return ApiResponse.createOK();
    }
}
