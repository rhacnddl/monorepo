package com.gorany.user.repository

import com.gorany.base.ApiQuerydslRepositorySupport
import com.gorany.base.CommonBooleanExpressions
import com.gorany.user.entity.QUserEntity.userEntity
import com.gorany.user.entity.UserEntity
import com.querydsl.jpa.impl.JPAQueryFactory

class UserSupportImpl(
    private val factory: JPAQueryFactory
): UserSupport, ApiQuerydslRepositorySupport(UserEntity::class.java) {

    override fun findByEmail(email: String): UserEntity? {
        return factory.selectFrom(userEntity)
            .where(
                CommonBooleanExpressions.isNotDeleted(userEntity.isDeleted),
                userEntity.email.eq(email)
            )
            .fetchOne()
    }
}
