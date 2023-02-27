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

        private fun validatePassword(password: String) {
            require(password.length >= 8) { "비밀번호는 8자 이상이어야 합니다." }
        }
    }
}
