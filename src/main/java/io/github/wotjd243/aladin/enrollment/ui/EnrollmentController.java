package io.github.wotjd243.aladin.enrollment.ui;

import io.github.wotjd243.aladin.enrollment.application.EnrollmentService;
import io.github.wotjd243.aladin.enrollment.dto.EnrollmentRequestDto;
import io.github.wotjd243.aladin.enrollment.dto.EnrollmentResponseDto;
import io.github.wotjd243.aladin.response.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/enrollment")
@RequiredArgsConstructor
public class EnrollmentController {

    private final EnrollmentService enrollmentService;

    @PostMapping
    public ApiResponse<EnrollmentResponseDto> save(@RequestBody EnrollmentRequestDto requestDto) {
        return ApiResponse.createOK(enrollmentService.save(requestDto));
    }

    @GetMapping("{id}")
    public ApiResponse<EnrollmentResponseDto> findBy(@PathVariable Long id) {
        return ApiResponse.createOK(enrollmentService.findById(id));
    }
}
