package com.gorany.user.repository

import com.gorany.user.entity.UserHistoryEntity
import org.springframework.data.jpa.repository.JpaRepository

interface UserHistoryJpaRepository: JpaRepository<UserHistoryEntity, Long>
