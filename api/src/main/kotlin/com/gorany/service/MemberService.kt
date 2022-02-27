package com.gorany.service

import com.gorany.dto.RequestMemberSignup
import com.gorany.entity.Member

interface MemberService {
    fun getMembers(): List<Member>
    fun signup(requestMemberSignup: RequestMemberSignup): Long
}