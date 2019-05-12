package io.github.book.collected.ui;

import io.github.book.collected.application.CollectedBookService;
import io.github.book.collected.application.dto.CollectedBookDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/api/v1/")
@RequiredArgsConstructor
public class CollectedController {
    private final CollectedBookService collectedBookService;

    @PostMapping("collected-book")
    public ResponseEntity save(@RequestBody CollectedBookDto collectedBookDto) {
        collectedBookService.saveCollectedBook(collectedBookDto);
        return ResponseEntity.ok("saved");

    }
}
