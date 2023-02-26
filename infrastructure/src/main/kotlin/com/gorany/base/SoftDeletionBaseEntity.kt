package com.gorany.base

import javax.persistence.Column
import javax.persistence.MappedSuperclass

@MappedSuperclass
abstract class SoftDeletionBaseEntity {

    @Column(name = "is_deleted")
    var isDeleted: Boolean = false
}
