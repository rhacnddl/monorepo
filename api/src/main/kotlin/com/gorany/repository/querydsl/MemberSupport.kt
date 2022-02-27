package com.gorany.repository.querydsl

import com.gorany.entity.Member

interface MemberSupport {
    fun getMembers(): List<Member>
}