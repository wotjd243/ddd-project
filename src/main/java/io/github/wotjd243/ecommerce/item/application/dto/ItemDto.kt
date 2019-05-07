package io.github.wotjd243.ecommerce.item.application.dto

data class ItemRequestDto(
        val title: String,
        val price: Double,
        val url: String
)

data class ItemResponseDto(
        val title: String,
        val price: Double,
        val url: String,
        val stock: Int,
        val state: String
)