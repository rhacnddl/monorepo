package com.gorany.repository.querydsl.impl

import com.gorany.entity.Member
import com.gorany.entity.QMember.member
import com.gorany.repository.querydsl.CustomQuerydslRepositorySupport
import com.gorany.repository.querydsl.MemberSupport
import com.querydsl.jpa.impl.JPAQueryFactory

class MemberSupportImpl(
    private val query: JPAQueryFactory,
) : CustomQuerydslRepositorySupport(Member::class.java), MemberSupport {

    override fun getMembers(): List<Member> {
        return query.selectFrom(member)
            .fetch()
    }
}