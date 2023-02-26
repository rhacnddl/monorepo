package com.gorany.base

import org.springframework.data.annotation.CreatedBy
import org.springframework.data.annotation.LastModifiedBy
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import javax.persistence.Column
import javax.persistence.EntityListeners
import javax.persistence.MappedSuperclass

@MappedSuperclass
@EntityListeners(value = [AuditingEntityListener::class])
abstract class BaseEntity : DateBaseEntity() {

    @CreatedBy
    @Column(name = "created_by", updatable = false)
    var createBy: String = "SYSTEM"
        protected set

    @LastModifiedBy
    @Column(name = "updated_by")
    var updatedBy: String = "SYSTEM"
        protected set
}
