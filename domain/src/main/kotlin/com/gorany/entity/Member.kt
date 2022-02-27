package com.gorany.entity

import com.gorany.entity.base.BaseEntity
import org.jetbrains.annotations.NotNull
import javax.persistence.Entity
import javax.persistence.EnumType
import javax.persistence.Enumerated
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class Member(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) val id: Long = 0,
    @Enumerated(EnumType.STRING) val role: MemberRole = MemberRole.MEMBER,
    val nickname: String? = null,
    @NotNull val email: String,
    @NotNull val password: String,
): BaseEntity()