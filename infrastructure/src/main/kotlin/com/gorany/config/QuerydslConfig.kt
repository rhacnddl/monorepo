package com.gorany.config

import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import javax.persistence.EntityManager
import javax.persistence.PersistenceContext

@Configuration
class QuerydslConfig(
    @PersistenceContext val apiEntityManager: EntityManager
) {
    @Bean
    fun apiQueryFactory() = JPAQueryFactory(apiEntityManager)
}
