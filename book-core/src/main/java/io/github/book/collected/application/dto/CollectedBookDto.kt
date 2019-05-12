package io.github.book.collected.application.dto

import io.github.book.collected.domain.BookLocation
import io.github.book.collected.domain.BookRentStatus

data class CollectedBookDto(
        var bookIsbn: String,
        var bookLocation: BookLocation,
        var bookRentStatus: BookRentStatus
) {
}