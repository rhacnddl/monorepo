package com.gorany.repository

import com.gorany.config.TestQuerydslConfig
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.context.annotation.Import
import org.springframework.transaction.annotation.Transactional

@DataJpaTest
@Import(TestQuerydslConfig::class)
@Transactional
class MemberRepositoryTests @Autowired constructor(
    val repository: MemberRepository,
) {

    @Test
    @DisplayName("Querydsl 테스트")
    fun querydsl_test() {
        //given

        //when
        val result = repository.getMembers()

        //then
        assertThat(result).isEmpty()
    }
}