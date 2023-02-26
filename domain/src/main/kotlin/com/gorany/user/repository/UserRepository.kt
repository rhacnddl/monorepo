package com.gorany.user.repository

import com.gorany.user.User

interface UserRepository {

    fun save(user: User)

    fun findByEmail(email: String): User?
}
