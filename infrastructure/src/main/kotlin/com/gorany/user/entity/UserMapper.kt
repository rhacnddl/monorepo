package com.gorany.user.entity

import com.gorany.base.BaseMapper
import com.gorany.user.User

object UserMapper: BaseMapper<User, UserEntity, User, UserEntity>() {
    override fun toDomainWithoutBase(entity: UserEntity): User {
        return User(
            id = entity.id,
            email = entity.email,
            password = entity.password,
            name = entity.name,
            roleId = entity.roleId,
        )
    }

    override fun toEntityWithoutBase(domain: User): UserEntity {
        return UserEntity(
            id = domain.id,
            email = domain.email,
            password = domain.password,
            name = domain.name,
            roleId = domain.roleId,
        )
    }
}
