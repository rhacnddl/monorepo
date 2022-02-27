package com.gorany.dto

import com.gorany.entity.Member
import com.gorany.entity.MemberRole

class RequestMemberSignup(
    val nickname: String,
    val password: String,
    val email: String,
    val role: MemberRole = MemberRole.MEMBER
) {
    fun of(): Member = Member(role = role, nickname = nickname, password = password, email = email)
}
