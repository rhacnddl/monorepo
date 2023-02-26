package com.gorany.user.entity

import com.gorany.base.BaseEntity
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "user")
class UserEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) val id: Long = 0L,
    @Column(name = "email") val email: String,
    @Column(name = "password") val password: String,
    @Column(name = "name") val name: String,
    @Column(name = "roleId") val roleId: Long,
): BaseEntity() {
}
