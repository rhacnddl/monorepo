package com.gorany.user.entity

import com.gorany.base.BaseEntity
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "user_history")
class UserHistoryEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) val id: Long = 0L,
    @Column(name = "user_id") val userId: Long,
    @Column(name = "email") val email: String,
    @Column(name = "password") val password: String,
    @Column(name = "name") val name: String,
    @Column(name = "roleId") val roleId: Long,
): BaseEntity() {
    companion object {
        fun of(entity: UserEntity): UserHistoryEntity = UserHistoryEntity(
            userId = entity.id,
            email = entity.email,
            password = entity.password,
            name = entity.name,
            roleId = entity.roleId,
        )
    }
}
