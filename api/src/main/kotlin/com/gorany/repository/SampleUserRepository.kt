package com.gorany.repository

import com.gorany.entity.SampleUser
import org.springframework.data.jpa.repository.JpaRepository

interface SampleUserRepository: JpaRepository<SampleUser, Long> {
}