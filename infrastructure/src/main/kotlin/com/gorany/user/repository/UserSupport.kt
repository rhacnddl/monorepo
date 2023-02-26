package com.gorany.user.repository

import com.gorany.user.entity.UserEntity

interface UserSupport {

    fun findByEmail(email: String): UserEntity?
}
