package com.gorany.user.request

data class CreateUserCommand(
    val email: String,
    val password: String,
    val name: String,
)
