package com.gorany.base

import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.ZonedDateTime
import javax.persistence.Column
import javax.persistence.EntityListeners
import javax.persistence.MappedSuperclass
import javax.persistence.PrePersist
import javax.persistence.PreUpdate

@MappedSuperclass
@EntityListeners(value = [AuditingEntityListener::class])
abstract class DateBaseEntity : SoftDeletionBaseEntity() {
    @Column(name = "created_at", nullable = false, updatable = false, columnDefinition = "DATE")
    var createdAt: ZonedDateTime = ZonedDateTime.now()
        protected set

    @Column(name = "updated_at", columnDefinition = "DATE")
    var updatedAt: ZonedDateTime = ZonedDateTime.now()
        protected set

    @PrePersist
    fun prePersist() {
        createdAt = ZonedDateTime.now()
        updatedAt = ZonedDateTime.now()
    }

    @PreUpdate
    fun preUpdate() {
        updatedAt = ZonedDateTime.now()
    }
}
