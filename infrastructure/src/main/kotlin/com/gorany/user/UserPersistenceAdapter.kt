package com.gorany.user

import com.gorany.user.entity.UserHistoryEntity
import com.gorany.user.repository.UserHistoryJpaRepository
import com.gorany.user.repository.UserJpaRepository
import com.gorany.user.repository.UserRepository
import org.springframework.stereotype.Component

@Component
class UserPersistenceAdapter(
    private val userJpaRepository: UserJpaRepository,
    private val userHistoryJpaRepository: UserHistoryJpaRepository,
): UserRepository {

    override fun save(user: User) {
        val entity = UserMapper.toEntity(user)

        userJpaRepository.save(entity)
        userHistoryJpaRepository.save(UserHistoryEntity.of(entity))
    }

    override fun findByEmail(email: String): User? {
        return (userJpaRepository.findByEmail(email))
            ?.let { UserMapper.toDomain(it) }
    }
}
