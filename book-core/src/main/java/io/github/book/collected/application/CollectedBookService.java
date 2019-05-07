package io.github.book.collected.application;

import io.github.book.collected.domain.BookRentStatus;
import io.github.book.collected.domain.CollectedBook;
import io.github.book.collected.infra.CollectedBookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class CollectedBookService {
    private final CollectedBookRepository collectedBookRepository;

    public List<CollectedBook> getRentAvailableCollectedBook() {
        return collectedBookRepository.findByBookRentStatus(BookRentStatus.RENT_AVAILABLE).orElse(new ArrayList<>());
    }

    @Transactional
    public CollectedBook saveCollectedBook(CollectedBook collectedBook) {
        return collectedBookRepository.save(collectedBook);
    }
}
