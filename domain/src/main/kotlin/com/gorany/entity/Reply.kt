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
class Reply(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) val id: Long = 0,
    @NotNull val comment: String,
    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "board_id") val board: Board,
    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "member_id") val member: Member
): BaseEntity()