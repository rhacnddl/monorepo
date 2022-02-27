package com.gorany.entity

import com.gorany.entity.base.BaseEntity
import org.jetbrains.annotations.NotNull
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne

@Entity
class Board(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) val id: Long = 0,
    @NotNull val title: String,
    val content: String,
    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "member_id") val member: Member,
    ): BaseEntity()