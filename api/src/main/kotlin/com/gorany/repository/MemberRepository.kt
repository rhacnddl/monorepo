package com.gorany.repository

import com.gorany.entity.Member
import com.gorany.repository.querydsl.MemberSupport
import org.springframework.data.jpa.repository.JpaRepository

interface MemberRepository: JpaRepository<Member, Long>, MemberSupport {
}