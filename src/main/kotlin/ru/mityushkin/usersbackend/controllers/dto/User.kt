package ru.mityushkin.usersbackend.controllers.dto

data class UserRequest(
    val name: String,
    val surname: String? = null,
    val email: String,
    var password: String
)

data class UserResponse(
    val name: String,
    val surname: String? = null,
    val email: String
)