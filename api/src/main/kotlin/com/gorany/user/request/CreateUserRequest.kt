package com.gorany.user.request

data class CreateUserRequest(
    val email: String,
    val password: String,
    val name: String,
) {
    fun toCommand(): CreateUserCommand = CreateUserCommand(email, password, name)
}
