package io.github.book.book.application.dto

import io.github.book.book.domain.Author
import java.time.LocalDate

data class BookDto(
        var isbn: String,
        var title: String,
        var author: Author,
        var description: String,
        var publishedDate: LocalDate
)
