package com.gorany.base

import java.time.ZonedDateTime

abstract class BaseDomain(
    var createdAt: ZonedDateTime? = null,
    var updatedAt: ZonedDateTime? = null,
    var createdBy: String? = null,
    var updatedBy: String? = null,
    var isDeleted: Boolean? = null,
)
