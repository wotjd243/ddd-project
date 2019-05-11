package io.github.wotjd243.ecommerce.order.application.dto

data class OrderResponseDto(
        val orderId: String,
        val buyerName: String,
        val buyerAddress: String,
        val orderedItems: List<String>,
        val totalPrice: Double
)