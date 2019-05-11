package io.github.wotjd243.ecommerce.user.application.dto

data class UserRequestDto(
        val userId: String,
        val address: String
)

data class UserResponseDto(
        val userId: String
)