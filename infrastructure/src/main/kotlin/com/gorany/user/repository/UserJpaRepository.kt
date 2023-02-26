package com.gorany.user.repository

import com.gorany.user.entity.UserEntity
import org.springframework.data.jpa.repository.JpaRepository

interface UserJpaRepository: JpaRepository<UserEntity, Long>, UserSupport
