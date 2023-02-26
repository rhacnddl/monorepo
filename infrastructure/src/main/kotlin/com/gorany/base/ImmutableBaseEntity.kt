package com.gorany.base

import org.springframework.data.annotation.CreatedBy
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.ZonedDateTime
import javax.persistence.Column
import javax.persistence.EntityListeners
import javax.persistence.MappedSuperclass

@MappedSuperclass
@EntityListeners(value = [AuditingEntityListener::class])
abstract class ImmutableBaseEntity {

    companion object ImmutableBaseEntity {
        private const val SYSTEM = "SYSTEM"
    }

    @CreatedBy
    @Column(name = "created_by", updatable = false)
    var createBy: String = SYSTEM
        protected set

    @CreatedDate
    @Column(name = "created_date", nullable = false, updatable = false, columnDefinition = "DATE")
    var createdAt: ZonedDateTime = ZonedDateTime.now()
        protected set
}
