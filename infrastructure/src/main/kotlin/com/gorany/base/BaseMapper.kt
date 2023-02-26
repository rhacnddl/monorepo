package com.gorany.base

abstract class BaseMapper<
        out OutputDomain : BaseDomain, in InputEntity : BaseEntity,
        in InputDomain : BaseDomain, out OutputEntity : BaseEntity,
        > {

    protected abstract fun toDomainWithoutBase(entity: InputEntity): OutputDomain

    protected abstract fun toEntityWithoutBase(domain: InputDomain): OutputEntity

    fun toDomain(entity: InputEntity): OutputDomain = toDomainWithoutBase(entity)
        .apply {
            createdAt = entity.createdAt
            updatedBy = entity.updatedBy
            updatedAt = entity.updatedAt
            createdBy = entity.createBy
            isDeleted = entity.isDeleted
        }

    fun toEntity(domain: InputDomain): OutputEntity = toEntityWithoutBase(domain)
        .apply {
            isDeleted = domain.isDeleted ?: false
        }
}
