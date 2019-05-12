package io.github.book.book.application.dto

import io.github.book.book.domain.Author
import java.time.LocalDate

data class BookDto(
        val isbn: String,
        val title: String,
        val author: Author,
        val description: String,
        val publishedDate: LocalDate
)
