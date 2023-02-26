package com.gorany.user

import com.gorany.base.BaseDomain
import com.gorany.enum.UserRole

data class User(
    val id: Long = 0L,
    val email: String,
    val password: String,
    val name: String,
    val roleId: Long,
) : BaseDomain() {
    companion object {
        fun of(email: String, password: String, name: String): User {
            validatePassword(password)

            return User(
                email = email,
                password = password,
                name = name,
                roleId = UserRole.COMMON.id,
            )
        }

        private fun validatePassword(password: String): Boolean {
            require(password.length >= 8)

            return true
        }
    }
}
